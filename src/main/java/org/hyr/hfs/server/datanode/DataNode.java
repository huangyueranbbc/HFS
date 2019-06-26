package org.hyr.hfs.server.datanode;

import org.hyr.hfs.annotation.RpcService;
import org.hyr.hfs.ipc.RPC;
import org.hyr.hfs.ipc.RpcServer;
import org.hyr.hfs.server.protocol.DataNodeProtocol;
import org.hyr.hfs.server.protocol.NameNodeProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/*******************************************************************************
 * @date 2019-06-26 13:49
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: DataNode
 ******************************************************************************/
@RpcService(DataNodeProtocol.class)
public class DataNode implements DataNodeProtocol, Runnable {
    private static Logger LOG = LoggerFactory.getLogger(DataNode.class);

    private final String versionId = UUID.randomUUID().toString();

    private NameNodeProtocol nameNode;

    private boolean shouldRun = true; // datanode是否结束信号

    private long heartBeatInterval = 3L * 1000L; // 心跳间隔
    private long lastHeartbeat = 0; // 心跳间隔

    public DataNode() {
        System.out.println("new DataNode!");

        // TODO 初始化各类对象

        // rpc获取namenode代理对象进行通信
        nameNode = RPC.getProxy(NameNodeProtocol.class, "127.0.0.1", 8255);
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
        DataNode dataNode = new DataNode();
        return dataNode;
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
        RpcServer ipcServer = new RpcServer(8255, "org.hyr.hfs.server.datanode", 5);
        ipcServer.start();
        System.out.println("ipcServer is start!");

        // FIXME
        while (shouldRun) {
            try {
                Thread.sleep(100);
                DataNodeProtocol datanodeProxy = RPC.getProxy(DataNodeProtocol.class, "127.0.0.1", 8255);
                System.out.println(datanodeProxy.getInfo());

                NameNodeProtocol nameNodeProxy = RPC.getProxy(NameNodeProtocol.class, "127.0.0.1", 8256);
                System.out.println(nameNodeProxy.getInfo());
            } catch (Exception e) {
                LOG.error("has error.",e);
            }
        }

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
            long startTime = now();

            // 达到心跳间隔 发送心跳
            if (startTime - lastHeartbeat > heartBeatInterval) {
                lastHeartbeat = startTime;
                // TODO 远程调用 上报心跳
                nameNode.getInfo();
            }
        }
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
    static long now() {
        return System.currentTimeMillis();
    }
}
