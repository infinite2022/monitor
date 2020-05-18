package com.ecs.monitor.bean;

import java.util.Date;

public class Proj1Params {
    private Integer id;

    private Integer scanDelay;

    private Integer keepLogTime;

    private Integer isActive;

    private String ips;

    private String contact;

    private Date pmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScanDelay() {
        return scanDelay;
    }

    public void setScanDelay(Integer scanDelay) {
        this.scanDelay = scanDelay;
    }

    public Integer getKeepLogTime() {
        return keepLogTime;
    }

    public void setKeepLogTime(Integer keepLogTime) {
        this.keepLogTime = keepLogTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips == null ? null : ips.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Date getPmtUpdate() {
        return pmtUpdate;
    }

    public void setPmtUpdate(Date pmtUpdate) {
        this.pmtUpdate = pmtUpdate;
    }
}