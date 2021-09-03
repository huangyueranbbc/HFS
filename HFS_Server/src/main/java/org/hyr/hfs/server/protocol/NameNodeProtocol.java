
package org.hyr.hfs.server.protocol;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description: RPC协议 和NameNode通信
 ******************************************************************************/
public interface NameNodeProtocol extends VersionedProtocol {

     String getInfo();

     long now();

}
