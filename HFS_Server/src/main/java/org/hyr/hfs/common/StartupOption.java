package org.hyr.hfs.common;

/*******************************************************************************
 * @date 2019-06-28 14:24
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description: namenode启动指令
 ******************************************************************************/
public enum StartupOption {

    NORMAL("-normal"),  //  正常启动
    FORMAT("-format"),  //  格式化文件系统
    UPGRADE("-upgrade");    // 更新

    private String name = null;

    StartupOption(String name) {
        this.name = name;
    }

    public static StartupOption parseArguments(String[] args) {
        int argsLen = (args == null) ? 0 : args.length;
        StartupOption defaultStartupOption = StartupOption.NORMAL;
        for (int i = 0; i < argsLen; i++) {
            String cmd = args[i];
            StartupOption startupOption = getByValue(cmd);
            return startupOption;
        }
        return defaultStartupOption;
    }

    public String getName() {
        return name;
    }

    public static StartupOption getByValue(String args) {
        for (StartupOption startupOption : values()) {
            if (startupOption.getName().equals(args)) {
                return startupOption;
            }
        }
        return null;
    }

}

