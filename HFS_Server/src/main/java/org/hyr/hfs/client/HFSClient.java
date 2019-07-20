package org.hyr.hfs.client;

import org.hyr.hfs.utils.NetUtils;

import javax.net.SocketFactory;

/*******************************************************************************
 * @date 2019-07-20 15:21
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class HFSClient {

    SocketFactory socketFactory = null;

    public HFSClient(SocketFactory socketFactory) {
        this.socketFactory = NetUtils.getSocketFactory();
    }
}
