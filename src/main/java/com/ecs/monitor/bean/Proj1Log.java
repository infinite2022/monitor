package com.ecs.monitor.bean;

import java.util.Date;

public class Proj1Log {
    private Long id;

    private String pname;

    private Integer pid;

    private Integer status;

    private Integer type;

    private Date pmtUpdate;

    private String log;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getPmtUpdate() {
        return pmtUpdate;
    }

    public void setPmtUpdate(Date pmtUpdate) {
        this.pmtUpdate = pmtUpdate;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log == null ? null : log.trim();
    }
}