package com.ecs.monitor.bean;

import java.util.Date;

public class Proj1Process {
    private Integer id;

    private Integer pid;

    private String pname;

    private String fpath;

    private Integer status;

    private Integer daemon;

    private Integer version;

    private Integer deleted;

    private Date pmtCreate;

    private Date pmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getFpath() {
        return fpath;
    }

    public void setFpath(String fpath) {
        this.fpath = fpath == null ? null : fpath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDaemon() {
        return daemon;
    }

    public void setDaemon(Integer daemon) {
        this.daemon = daemon;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getPmtCreate() {
        return pmtCreate;
    }

    public void setPmtCreate(Date pmtCreate) {
        this.pmtCreate = pmtCreate;
    }

    public Date getPmtUpdate() {
        return pmtUpdate;
    }

    public void setPmtUpdate(Date pmtUpdate) {
        this.pmtUpdate = pmtUpdate;
    }

    public Proj1Process initDefault(){
        Date date = new Date();
        this.setVersion(0);
        this.setDeleted(0);
        this.setStatus(2);
        this.setPmtCreate(date);
        this.setPmtUpdate(date);
        return this;
    }
    public Proj1Process initUpdateDate(){
        this.setPmtUpdate(new Date());
        return this;
    }
}