package org.hyr.hfs.server.protocol;

import java.io.Serializable;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class RpcResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Throwable error;
    private Object result;
	public Throwable getError() {
		return error;
	}
	public void setError(Throwable error) {
		this.error = error;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
    
    
}
