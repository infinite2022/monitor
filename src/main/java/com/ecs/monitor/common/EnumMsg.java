package com.ecs.monitor.common;

public enum EnumMsg {
    //成功
    SUCCESS(200, "响应成功"),

    ACCOUT_LOGIN(201, "登录成功"),
    OPERATION_COMPLETE(202, "操作已执行"),
    FILE_IS_EXISTS(203,"文件已存在"),
    FILE_IS_NOT_EXISTS(204,"文件不存在"),
    START_SUCCESS(205,"启动成功"),

    //失败
    PATH_OR_FILE_FORMAT_ERROR(600, "绝对路径或文件名有误"),
    START_FAILURE(601, "启动失败"),
    THREAD_DEATH(602, "程序异常宕掉"),
    BASH_OPERATION_FAILURE(603, "文件错误(丢失|异常|权限等)"),
    NOT_ENOUGH_MEMORY(604, "空闲内存不足"),
    CPU_BUSSY(605, "系统CPU占用率过高"),
    ACCOUT_NON_EXISTENT(606, "帐号不存在"),
    PASSWORD_ERROR(607, "密码错误"),
    NON_IN_PROCESS(608, "当前没有运行的程序"),
    SESSION_SYSTEM_LOAD_FAILURE(609,"会话程序加载失败"),
    ECS_MONITOR_START_FAILURE(610, "监控程序启动异常");

    private int code;
    private String msg;

    private EnumMsg() {
    }

    EnumMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        if (code >= 200 && code <= 300) {
            return 200;
        } else if (code >= 600 && code <= 700) {
            return 400;
        }
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
