package org.hyr.hfs.server.datanode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.SocketFactory;
import java.net.Socket;

/*******************************************************************************
 * @date 2019-07-20 11:53
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class DataProcesser implements Runnable {

    private final static Logger LOG = LoggerFactory.getLogger(DataProcesser.class);

    Socket socket;
    DataNode dataNode;
    DataProcessorServer dataProcessorServer;

    final String remoteAddress; // address of remote side
    final String localAddress;  // local address of this daemon

    public DataProcesser(Socket socket, DataNode dataNode, DataProcessorServer dataProcessorServer) {
        LOG.info("start create DataProcesser.");
        this.socket = socket;
        this.dataNode = dataNode;
        this.dataProcessorServer = dataProcessorServer;

        remoteAddress = socket.getRemoteSocketAddress().toString();
        localAddress = socket.getLocalSocketAddress().toString();
    }

    /**
     * TODO 处理接收数据
     */
    @Override
    public void run() {
        // TODO 数据传输协议格式定义
    }
}
