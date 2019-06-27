package org.hyr.hfs.server.protocol;

import java.io.DataInputStream;
import java.io.IOException;

/*******************************************************************************
 *
 * @date 2019-06-27 13:38 
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: 存放datanode基本信息
 ******************************************************************************/
public class DataNodeId  {

    public String nodeName;
    public String hostname;    // data transfer hostname
    public int port;            // data transfer port
    public String ipcHostname; // ipc hostname
    public int ipcPort;       // ipc server port


    public DataNodeId(String nodeName) {
        this.nodeName = nodeName;
    }

    public DataNodeId(String nodeName, String hostname, int port, String ipcHostname, int ipcPort) {
        this.nodeName = nodeName;
        this.hostname = hostname;
        this.port = port;
        this.ipcHostname = ipcHostname;
        this.ipcPort = ipcPort;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIpcHostname() {
        return ipcHostname;
    }

    public void setIpcHostname(String ipcHostname) {
        this.ipcHostname = ipcHostname;
    }

    public int getIpcPort() {
        return ipcPort;
    }

    public void setIpcPort(int ipcPort) {
        this.ipcPort = ipcPort;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /** {@inheritDoc} */
    public void readFields(DataInputStream dis) throws IOException {
        // TODO do something
    }
}
