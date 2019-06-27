package org.hyr.hfs.server.protocol;

import org.hyr.hfs.store.StorageInfo;

import java.io.*;

/*******************************************************************************
 *
 * @date 2019-06-27 13:39 
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: datanode注册 TODO 业务扩充
 ******************************************************************************/
public class DatanodeRegInfo extends DataNodeId implements Serializable {

    public StorageInfo storageInfo;

    public DatanodeRegInfo(String nodeName) {
        super(nodeName);
        this.storageInfo = new StorageInfo();
    }

    public DatanodeRegInfo(String nodeName, String hostname, int port, String ipcHostname, int ipcPort) {
        super(nodeName, hostname, port, ipcHostname, ipcPort);
        this.storageInfo = new StorageInfo();
    }

    public int getStoreVersion(){
        return storageInfo.getStoreVersion();
    }

    /** {@inheritDoc} */
    public void readFields(DataInputStream dis) throws IOException {
        super.readFields(dis);
        this.storageInfo.storeVersion=dis.readInt();
        this.storageInfo.namespaceID=dis.readInt();
        this.storageInfo.createTime=dis.readLong();
    }
}
