package org.hyr.hfs.server.protocol;

import java.io.Serializable;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class RpcRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String className;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] params;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Class<?>[] getParamTypes() {
		return paramTypes;
	}
	public void setParamTypes(Class<?>[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}

}
