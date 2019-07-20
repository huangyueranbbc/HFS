package org.hyr.hfs.store;

import java.io.Serializable;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: 存储信息基类
 ******************************************************************************/
public class StorageInfo implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -1;


    public int storeVersion;  // Version read from the stored file.
    public int namespaceID;    // namespace id of the storage
    public long createTime;          // creation timestamp

    public int getStoreVersion() {
        return storeVersion;
    }

    public void setStoreVersion(int storeVersion) {
        this.storeVersion = storeVersion;
    }

    public int getNamespaceID() {
        return namespaceID;
    }

    public void setNamespaceID(int namespaceID) {
        this.namespaceID = namespaceID;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StorageInfo{" +
                "storeVersion=" + storeVersion +
                ", namespaceID=" + namespaceID +
                ", createTime=" + createTime +
                '}';
    }
}