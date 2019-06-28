package org.hyr.hfs.server.datanode;

import org.hyr.hfs.annotation.RpcService;
import org.hyr.hfs.command.DatanodeCommand;
import org.hyr.hfs.common.HFSConstant;
import org.hyr.hfs.ipc.RPC;
import org.hyr.hfs.ipc.RpcServer;
import org.hyr.hfs.server.protocol.DataNodeProtocol;
import org.hyr.hfs.server.protocol.DatanodeRegInfo;
import org.hyr.hfs.server.protocol.NameNodeProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

/*******************************************************************************
 * @date 2019-06-26 13:49
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: DataNode
 ******************************************************************************/
@RpcService(NameNodeProtocol.class)
public class DataNode implements Runnable {
    private static Logger LOG = LoggerFactory.getLogger(DataNode.class);

    private final String versionId = UUID.randomUUID().toString();

    private DataNodeProtocol nameNode;

    private boolean shouldRun = true; // datanode是否结束信号

    private long heartBeatInterval = 3L * 1000L; // 心跳间隔
    private long lastHeartbeat = 0; // 心跳间隔

    private RpcServer ipcServer;

    DatanodeRegInfo datanodeRegInfo;

    public DataNode() {
        try {
            System.out.println("start new DataNode!");
            // TODO 用户Login认证

            startDataNode();
        } catch (Exception e) {
            shutdown();
            e.printStackTrace();
        }

    }

    private void startDataNode() throws Exception {
        // rpc获取namenode代理对象进行通信
        nameNode = RPC.getProxy(DataNodeProtocol.class, HFSConstant.NAME_NODE_MACHINE_NAME, HFSConstant.NAME_NODE_IPC_PORT);

        // 初始化datanode注册信息
        datanodeRegInfo = new DatanodeRegInfo(HFSConstant.DATA_NODE_MACHINE_NAME);
        datanodeRegInfo.setHostname(HFSConstant.DATA_NODE_MACHINE_NAME);
        // TODO datanodeRegInfo.setPort(port);
        datanodeRegInfo.setIpcHostname(HFSConstant.DATA_NODE_MACHINE_NAME);
        datanodeRegInfo.setIpcPort(HFSConstant.DATA_NODE_IPC_PORT);

        // 读取version信息
        // FIXME 该操作放入format进行
        FileOutputStream fos = new FileOutputStream(HFSConstant.VERSION_PATH);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(HFSConstant.DEFAULT_STORE_VERSION); // storeVersion
        dos.writeInt(HFSConstant.DEFAULT_NAMESPACEID); // namespaceID
        dos.writeLong(HFSConstant.DEFAULT_STORE_CREATE_TIME); // createTime
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream(HFSConstant.VERSION_PATH));
        datanodeRegInfo.readFields(dis);
        dis.close();

    }

    private static DataNode createDataNode() {
        System.out.println("start createDataNode!");
        DataNode dataNode = initDataNode();
        runDataNode(dataNode);
        return dataNode;
    }

    private static void runDataNode(DataNode dataNode) {
        // TODO 启动线程
        new Thread(dataNode).start();
        System.out.println("datanode is start!");
    }

    /**
     * 初始化datanode
     *
     * @return
     */
    private synchronized static DataNode initDataNode() {
        DataNode dataNode = instantiateDataNode(); // 初始化
        return dataNode;
    }

    /**
     * 初始化相关信息
     *
     * @return
     */
    private static DataNode instantiateDataNode() {
        try {
            // TODO 文件系统 权限认证 确保有读写权限


            return new DataNode();
        } catch (Exception e) {
            return null;
        }
    }

    public String getInfo() {
        return "datanode:" + versionId + new Date().toLocaleString();
    }

    public long getProtocolVersion() {
        return 222;
    }

    /**
     * TODO datanode核心业务 offerservice
     */
    public void run() {
        // 启动RPC服务
        ipcServer = new RpcServer(HFSConstant.DATA_NODE_IPC_PORT, "org.hyr.hfs.server.datanode", HFSConstant.IPC_HANDLER_COUNT);
        ipcServer.start();
        System.out.println("ipcServer is start!");

//        // FIXME
//        while (shouldRun) {
//            try {
//                Thread.sleep(100);
//                DataNodeProtocol datanodeProxy = RPC.getProxy(DataNodeProtocol.class, "127.0.0.1", 8255);
//                System.out.println(datanodeProxy.getInfo());
//
//                NameNodeProtocol nameNodeProxy = RPC.getProxy(NameNodeProtocol.class, "127.0.0.1", 8256);
//                System.out.println(nameNodeProxy.getInfo());
//            } catch (Exception e) {
//                LOG.error("has error.", e);
//            }
//        }

        // TODO 核心业务 上报心跳、处理rpc请求、处理数据......
        while (shouldRun) {
            try {
                // TODO startDistributedUpgradeIfNeeded();
                offerservice();
            } catch (Exception e) {
                LOG.error("datanode run has error.", e);
            }
        }

        shutdown(); // stop the datanode world


    }

    /**
     * stop the datanode world
     */
    private void shutdown() {
        // stop rpc
        if (ipcServer != null) {
            ipcServer.running = false;
        }

        RPC.stopProxy(nameNode); // stop the RPC threads
    }

    /**
     * TODO 核心业务
     * 循环知道datanode结束
     * 不断远程调用namenode的方法，进行通信
     */
    private void offerservice() {
        LOG.info("datanode offerservice is run...");

        while (shouldRun) {
            try {
                long startTime = now();

                // 达到心跳间隔 发送心跳
                if (startTime - lastHeartbeat > heartBeatInterval) {
                    lastHeartbeat = startTime;
                    // TODO 远程调用 上报心跳 datanode和namenode唯一通信方式
                    DatanodeCommand[] datanodeCommands = nameNode.sendHeartbeat(datanodeRegInfo);

                    // 处理namenode下达的指令 失败则等待下一次心跳通信
                    if (!processCommand(datanodeCommands)) {
                        continue;
                    }
                }

            } catch (Exception e) {
                LOG.error("offerservice has error.", e);
            }

        }
    }

    /**
     * 处理namenode下达的指令
     *
     * @param datanodeCommands
     * @return
     */
    private boolean processCommand(DatanodeCommand[] datanodeCommands) {
        if (datanodeCommands != null) {
            for (DatanodeCommand cmd : datanodeCommands) {
                try {
                    if (processCommand(cmd) == false) {
                        return false;
                    }
                } catch (Exception e) {
                    LOG.error("Error processing datanode Command", e);
                }
            }
        }
        return true;
    }

    /**
     * 具体处理指令逻辑
     *
     * @param cmd
     * @return
     */
    private boolean processCommand(DatanodeCommand cmd) {
        if (cmd == null)
            return true;

        DataNodeProtocol.DATA_NODE_ACTION action = DataNodeProtocol.DATA_NODE_ACTION.getByValue(cmd.getAction());
        switch (action) {
            case DNA_SHUTDOWN:
                LOG.info("get DNA_SHUTDOWN action:{}", action);
                return false;
            default:
                LOG.info("Unknown DatanodeCommand action:{}", action);
                break;
        }
        return true;
    }

    private void join() {
        while (shouldRun) {
            try {
                synchronized (this) {
                    wait(2000);
                }
            } catch (InterruptedException ex) {
                LOG.warn("Received exception in Datanode#join: " + ex);
            }
        }
    }

    /**
     * Current system time.
     *
     * @return current time in msec.
     */
    public long now() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        int errorCode = 0;
        try {
            DataNode datanode = createDataNode();
            if (datanode != null) {
                datanode.join();
                LOG.info("start...");
            } else {
                errorCode = 1;
            }
        } catch (Throwable e) {
            LOG.error("Exception in secureMain", e);
        } finally {
            LOG.warn("Exiting Datanode");
        }
    }
}
