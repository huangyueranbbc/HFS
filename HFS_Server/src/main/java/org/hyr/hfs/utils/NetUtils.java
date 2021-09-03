package org.hyr.hfs.utils;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/*******************************************************************************
 * @date 2019-07-20 11:31
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class NetUtils {

    /**
     * FIXME 后期统一修改优化
     * @param ss
     * @param host
     * @param port
     * @throws IOException
     */
    public static void bindNet(ServerSocket ss, String host, int port) throws IOException {
        // InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved(host, port);
        InetSocketAddress inetSocketAddress2= new InetSocketAddress(port);
        ss.bind(inetSocketAddress2, 0);
    }


    /**
     * FIXME 后期统一修改优化
     * @throws IOException
     * @return
     */
    public static SocketFactory getSocketFactory(){
        return SocketFactory.getDefault();
    }


}
