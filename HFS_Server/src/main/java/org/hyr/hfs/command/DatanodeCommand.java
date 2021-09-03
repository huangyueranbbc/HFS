package org.hyr.hfs.command;

import org.hyr.hfs.server.protocol.DataNodeProtocol;

import java.io.Serializable;

/*******************************************************************************
 * @date 2019-06-27 13:26
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description: DataNode交互指令
 ******************************************************************************/
public class DatanodeCommand implements Serializable {

    private int action;

    public DatanodeCommand() {
        this(DataNodeProtocol.DATA_NODE_ACTION.DNA_UNKNOWN.getAction());
    }

    public DatanodeCommand(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
