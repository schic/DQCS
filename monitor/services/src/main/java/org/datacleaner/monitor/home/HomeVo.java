package org.datacleaner.monitor.home;

public class HomeVo {

    //任务总数
    static int jobNum;
    //数据源
    static int datastoresNum;
    //时间线分析
    static int groupsNum;
    //今日运行
    static int filesNum;
    //运行结果
    static int filesNumTd;

    public static int getJobNum() {
        return jobNum;
    }

    public static void setJobNum(int jobNum) {
        HomeVo.jobNum = jobNum;
    }

    public static int getDatastoresNum() {
        return datastoresNum;
    }

    public static void setDatastoresNum(int datastoresNum) {
        HomeVo.datastoresNum = datastoresNum;
    }

    public static int getGroupsNum() {
        return groupsNum;
    }

    public static void setGroupsNum(int groupsNum) {
        HomeVo.groupsNum = groupsNum;
    }

    public static int getFilesNum() {
        return filesNum;
    }

    public static void setFilesNum(int filesNum) {
        HomeVo.filesNum = filesNum;
    }

    public static int getFilesNumTd() {
        return filesNumTd;
    }

    public static void setFilesNumTd(int filesNumTd) {
        HomeVo.filesNumTd = filesNumTd;
    }

}
