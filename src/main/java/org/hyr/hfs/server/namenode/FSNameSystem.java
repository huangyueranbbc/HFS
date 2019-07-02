package org.hyr.hfs.server.namenode;

import org.hyr.hfs.command.DatanodeCommand;
import org.hyr.hfs.command.ShutDownCommand;

import java.util.ArrayList;

/*******************************************************************************
 * @date 2019-06-28 10:47 
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: TODO 维护着监视线程、网络拓扑结构、租约管理等等
 ******************************************************************************/
public class FSNameSystem {
    public FSNameSystem() {
    }

    /**
     * 处理心跳
     *
     * @return
     */
    public DatanodeCommand[] handleHeartbeat() {
        ArrayList<DatanodeCommand> cmds = new ArrayList<DatanodeCommand>();
        cmds.add(new ShutDownCommand());    // FIXME
        DatanodeCommand[] datanodeCommands = cmds.toArray(new DatanodeCommand[cmds.size()]);
        return datanodeCommands;
    }

    /**
     * 更新租约
     */


    /**
     * 监视线程
     */
}