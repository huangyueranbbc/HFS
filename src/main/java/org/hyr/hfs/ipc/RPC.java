package org.hyr.hfs.ipc;

import org.hyr.hfs.client.RpcClientProxy;
import org.hyr.hfs.server.protocol.NameNodeProtocol;

import java.lang.reflect.Proxy;

/*******************************************************************************
 * @date 2019-06-26 16:38
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class RPC {

    /**
     * 获取远程调用代理
     * @param clazz
     * @param ip    ip地址
     * @param port  端口
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> clazz, String ip, int port) {
        RpcClientProxy proxy = new RpcClientProxy(ip, port);
        return proxy.getProxy(clazz);
    }

    /**
     * TODO
     * @param clazz
     * @param ip
     * @param port
     * @param <T>
     * @return
     */
    public static <T> T waitForProxy(Class<T> clazz, String ip, int port) {
      return null;
    }

    public static void stopProxy(NameNodeProtocol proxy) {
        if (proxy != null) {
            ((RpcClientProxy) Proxy.getInvocationHandler(proxy)).close();
        }
    }
}
