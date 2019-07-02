package org.hyr.hfs.server.namenode;

import org.hyr.hfs.annotation.RpcService;
import org.hyr.hfs.command.DatanodeCommand;
import org.hyr.hfs.common.HFSConstant;
import org.hyr.hfs.common.StartupOption;
import org.hyr.hfs.exceptions.IncorrectVersionException;
import org.hyr.hfs.ipc.RpcServer;
import org.hyr.hfs.server.protocol.DataNodeProtocol;
import org.hyr.hfs.server.protocol.DatanodeRegInfo;
import org.hyr.hfs.server.protocol.NameNodeProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/*******************************************************************************
 * @date 2019-06-26 13:47
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
@RpcService(DataNodeProtocol.class)
public class NameNode implements DataNodeProtocol, NameNodeProtocol {

    private final static Logger LOG = LoggerFactory.getLogger(NameNode.class);

    private final String versionId = UUID.randomUUID().toString();

    private RpcServer ipcServer;

    private FSNameSystem fsNameSystem;

    private boolean shouldRun = true;

    private static NameNode createNameNode(String[] args) {
        StartupOption startOpt = StartupOption.parseArguments(args);
        if (startOpt == null) {
            printUsage();
            System.exit(-2);
        }

        // setStartupOption(conf,startOpt); // TODO 启动配置相关

        switch (startOpt) {
            case FORMAT:
                boolean aborted = format();
                System.exit(aborted ? 1 : 0);
            case NORMAL:
                aborted = true;
            default:
        }

        return new NameNode(true);
    }

    /**
     * 格式化操作
     *
     * @return
     */
    private static boolean format() {
        // FIXME 该操作放入format进行
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(HFSConstant.VERSION_PATH);
            dos = new DataOutputStream(fos);
            dos.writeInt(HFSConstant.DEFAULT_STORE_VERSION); // storeVersion
            dos.writeInt(HFSConstant.DEFAULT_NAMESPACEID); // namespaceID
            dos.writeLong(HFSConstant.DEFAULT_STORE_CREATE_TIME); // createTime
            dos.close();
            return true;
        } catch (Exception e) {
            LOG.error("Format has error.", e);
            return false;
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                LOG.error("Format OutputStream close has error.", e);
            }

        }

    }

    private static void printUsage() {
        System.err.println(
                "Usage: java NameNode [ " +
                        StartupOption.FORMAT.getName() + " [" + StartupOption.UPGRADE.getName() +
                        " ] ]");
    }



    public NameNode(boolean shouldRun) {
        this.shouldRun = shouldRun;
        initNameNode();
        new NameNode();
    }

    public NameNode() {
        this.fsNameSystem = new FSNameSystem();
    }

    private void initNameNode() {
        try {
            // RPC服务启动
            ipcServer = new RpcServer(HFSConstant.NAME_NODE_IPC_PORT, "org.hyr.hfs.server.namenode", HFSConstant.IPC_HANDLER_COUNT);
            ipcServer.start();
        } catch (Exception e) {
            LOG.error("initNameNode is error");
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

    public String getInfo() {
        return "namenode:" + versionId + new Date().toLocaleString();
    }

    /**
     * sent heart beat to namenode
     *
     * @param datanodeRegInfo
     * @return
     */
    public DatanodeCommand[] sendHeartbeat(DatanodeRegInfo datanodeRegInfo) throws IOException {
        verification(datanodeRegInfo);
        return this.fsNameSystem.handleHeartbeat();
    }

    private void verification(DatanodeRegInfo datanodeRegInfo) throws IOException {
        LOG.info("get datanodeRegInfo:" + datanodeRegInfo);
        if (datanodeRegInfo.getStoreVersion() != HFSConstant.LAYOUT_VERSION)
            throw new IncorrectVersionException(datanodeRegInfo.getStoreVersion(), "data node");
    }

    /**
     * namenode shutdonw
     */
    public void shutdown(){

    }

    public long now() {
        return System.currentTimeMillis();
    }

    public long getProtocolVersion() {
        return 111;
    }

    public static void main(String[] args) {
        // args=new String[]{"-format"};
        int errorCode = 0;
        try {
            NameNode datanode = createNameNode(args);
            if (datanode != null) {
                datanode.join();
                LOG.info("start...");
            } else {
                errorCode = 1;
            }
        } catch (Throwable e) {
            LOG.error("Exception in secureMain", e);
            System.exit(-1);
        } finally {
            LOG.warn("Exiting Datanode");
            System.exit(0);
        }
    }
}
