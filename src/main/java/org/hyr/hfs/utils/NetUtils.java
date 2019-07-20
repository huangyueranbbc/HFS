package org.hyr.hfs.utils;

import org.hyr.hfs.common.HFSConstant;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/*******************************************************************************
 * @date 2019-07-20 11:31
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class NetUtils {

    public static void bindNet(ServerSocket ss, String host, int port) throws IOException {
        // InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved(host, port);
        InetSocketAddress inetSocketAddress2= new InetSocketAddress(port);
        ss.bind(inetSocketAddress2, 0);
    }

}
