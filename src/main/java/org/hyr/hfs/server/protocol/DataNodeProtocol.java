
package org.hyr.hfs.server.protocol;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: RPC协议 和DataNode通信
 ******************************************************************************/
public interface DataNodeProtocol extends VersionedProtocol {

    String getInfo();

    /**
     * 上报心跳
     * @return
     * @param datanodeRegInfo
     */
    DatanodeCommand[] sendHeartbeat(DatanodeRegInfo datanodeRegInfo);

    long now();

}
