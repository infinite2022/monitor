package com.ecs.monitor.bean;

import java.util.Date;

public class Proj1Role {
    private Integer id;

    private String mobile;

    private String password;

    private Integer level;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Proj1Role initDefault(){
        Date date = new Date();
        this.setVersion(0);
        this.setDeleted(0);
        this.setPmtCreate(date);
        this.setPmtUpdate(date);
        return this;
    }
    public Proj1Role initUpdateDate(){
        this.setPmtUpdate(new Date());
        return this;
    }
}