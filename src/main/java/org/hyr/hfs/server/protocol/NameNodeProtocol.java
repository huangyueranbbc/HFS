
package org.hyr.hfs.server.protocol;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: RPC协议
 ******************************************************************************/
public interface NameNodeProtocol extends VersionedProtocol {

    public String getInfo();

}
