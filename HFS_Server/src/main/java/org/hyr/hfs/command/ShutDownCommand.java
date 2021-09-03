package org.hyr.hfs.command;

import org.hyr.hfs.server.protocol.DataNodeProtocol;

/*******************************************************************************
 * @date 2019-06-28 11:00
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class ShutDownCommand extends DatanodeCommand{

    public ShutDownCommand() {
        super(DataNodeProtocol.DATA_NODE_ACTION.DNA_SHUTDOWN.getAction());
    }
}
