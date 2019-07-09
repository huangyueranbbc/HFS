package org.hyr.hfs.client;


import org.hyr.hfs.server.protocol.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class RpcClientProxy implements InvocationHandler{
	private String host;
	private int port;
	
	public RpcClientProxy(String host, int port){
		this.host = host;
		this.port = port;
	}
	
	/**
	 * 生成代理对象
	 * @param clazz 代理类型（接口）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T>T getProxy(Class<T> clazz){
		// clazz不是接口不能使用JDK动态代理
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, RpcClientProxy.this);
	}

	public Object invoke(Object obj, Method method, Object[] params) throws Throwable {
		//封装参数
		RpcRequest request = new RpcRequest();
		request.setClassName(method.getDeclaringClass().getName());
		request.setMethodName(method.getName());
		request.setParamTypes(method.getParameterTypes());
		request.setParams(params);
		//链接服务器调用服务
		RpcClient client = new RpcClient();
		return client.start(request, host, port);
	}

	/**
     * TODO 通过缓存池进行维护
	 */
	public void close() {

	}
}
