package org.hyr.hfs.common;

import java.util.Date;

/*******************************************************************************
 *
 * @date 2019-06-27 14:51 
 * @author: <a href=mailto:@essence.com.cn>黄跃然</a>
 * @Description: 常量存储 主要是配置相关 TODO 从配置文件中读取
 ******************************************************************************/
public class HFSConstant {

    public final static String VERSION_PATH = "VERSION";

    public final static String DATA_NODE_MACHINE_NAME = "127.0.0.1";
    public final static Integer DATA_NODE_IPC_PORT = 8255;

    public final static String NAME_NODE_MACHINE_NAME = "127.0.0.1";
    public final static Integer NAME_NODE_IPC_PORT = 8256;


    public final static Integer DEFAULT_STORE_VERSION = -101;
    public final static Integer DEFAULT_NAMESPACEID = 888888;
    public final static Long DEFAULT_STORE_CREATE_TIME = new Date().getTime();

    public final static Integer IPC_HANDLER_COUNT = 3;


}
