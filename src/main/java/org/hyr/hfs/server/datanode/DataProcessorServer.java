package org.hyr.hfs.server.datanode;

import org.hyr.hfs.thread.Daemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*******************************************************************************
 * @date 2019-07-20 11:22
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class DataProcessorServer implements Runnable {

    private final static Logger LOG = LoggerFactory.getLogger(DataProcessorServer.class);

    DataNode dataNode;
    ServerSocket serverSocket;

    public DataProcessorServer(ServerSocket serverSocket, DataNode dataNode) {
        this.serverSocket = serverSocket;
        this.dataNode = dataNode;
    }

    @Override
    public void run() {
        while (dataNode.shouldRun){
            try {
                Socket socket = serverSocket.accept();
                socket.setTcpNoDelay(true); // 立即发送数据

                // 创建一个数据处理着线程进行处理数据
                new Daemon(dataNode.threadGroup,
                        new DataProcesser(socket, dataNode, this)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
