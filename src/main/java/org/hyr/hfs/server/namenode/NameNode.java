package org.hyr.hfs.server.namenode;

import org.hyr.hfs.annotation.RpcService;
import org.hyr.hfs.ipc.RpcServer;
import org.hyr.hfs.server.protocol.DataNodeProtocol;
import org.hyr.hfs.server.protocol.NameNodeProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/*******************************************************************************
 * @date 2019-06-26 13:47
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
@RpcService(NameNodeProtocol.class)
public class NameNode implements DataNodeProtocol {

    private static Logger LOG = LoggerFactory.getLogger(NameNode.class);

    private final String versionId = UUID.randomUUID().toString();

    private boolean shouldRun = true;


    public static void main(String[] args) {
        int errorCode = 0;
        try {
            NameNode datanode = createNameNode();
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

    private static NameNode createNameNode() {
        return initNameNode();
    }


    private static NameNode initNameNode() {
        try {
            RpcServer ipcServer = new RpcServer(8256, "org.hyr.hfs.server.namenode", 5);
            ipcServer.start();
            return new NameNode();
        } catch (Exception e) {
            LOG.error("initNameNode is error");
            return null;
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
        return "namenode:" + versionId+new Date().toLocaleString();
    }

    public long getProtocolVersion() {
        return 111;
    }
}
