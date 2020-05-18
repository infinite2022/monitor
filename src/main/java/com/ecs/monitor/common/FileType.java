package com.ecs.monitor.common;

public enum FileType {
    MYSQL_TYPE(0),
    TOMCAT_TYPE(1),
    JAR_TYPE(2);

    private int code;

    FileType(){}
    FileType(int code){
        this.code = code;
    }
    public static final int mysql_type = 0;
    public static final int tomcat_type = 1;
}
