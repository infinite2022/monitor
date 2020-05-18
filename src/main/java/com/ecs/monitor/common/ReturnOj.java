package com.ecs.monitor.common;

import com.google.gson.Gson;

public class ReturnOj<T> {
    private String code;
    private String msg;
    private T data;

    public ReturnOj() {
    }

    public ReturnOj(T data, EnumMsg enumMsg) {
        this.code = enumMsg.getCode() + "";
        if (SysUtil.getLanguage() == "cn") {
            this.msg = enumMsg.getMsg();
        } else {
            this.msg = enumMsg.name();
        }

        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public ReturnOj setCode(EnumMsg enumMsg) {
        this.code = enumMsg.getCode() + "";
        if (SysUtil.getLanguage() == "cn") {
            this.msg = enumMsg.getMsg();
        } else {
            this.msg = enumMsg.name();
        }

        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnOj setMsg(EnumMsg enumMsg) {
        this.code = enumMsg.getCode() + "";
        if (SysUtil.getLanguage() == "cn") {
            this.msg = enumMsg.getMsg();
        } else {
            this.msg = enumMsg.name();
        }

        return this;
    }

    public T getData() {
        return data;
    }

    public ReturnOj setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }
}
