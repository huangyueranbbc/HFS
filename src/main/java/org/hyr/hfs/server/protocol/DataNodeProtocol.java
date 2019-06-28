
package org.hyr.hfs.server.protocol;

import org.hyr.hfs.command.DatanodeCommand;

import java.io.IOException;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: RPC协议 和DataNode通信
 ******************************************************************************/
public interface DataNodeProtocol extends VersionedProtocol {

    String getInfo();

    /**
     * 上报心跳
     *
     * @param datanodeRegInfo
     * @return
     */
    DatanodeCommand[] sendHeartbeat(DatanodeRegInfo datanodeRegInfo) throws IOException;

    long now();

    public enum DATA_NODE_ACTION {
        DNA_UNKNOWN(0),     // 未知操作
        DNA_SHUTDOWN(1);    // 停止DataNode

        DATA_NODE_ACTION(int action) {
            this.action = action;
        }

        private int action = 0;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public static DATA_NODE_ACTION getByValue(Integer code) {
            for (DATA_NODE_ACTION action : values()) {
                if (action.getAction() == code) {
                    return action;
                }
            }
            return DATA_NODE_ACTION.DNA_UNKNOWN;
        }
    }
}
