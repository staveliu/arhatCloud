package com.newer.domain;

import java.util.Date;

public class Printer {
    private Integer printid;

    private String name;

    private Integer addrid;

    private String accessToken;

    private Integer status;

    private Date addTime;

    private Date lastchangeTime;

    private String printerInfo;

    public Integer getPrintid() {
        return printid;
    }

    public void setPrintid(Integer printid) {
        this.printid = printid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAddrid() {
        return addrid;
    }

    public void setAddrid(Integer addrid) {
        this.addrid = addrid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLastchangeTime() {
        return lastchangeTime;
    }

    public void setLastchangeTime(Date lastchangeTime) {
        this.lastchangeTime = lastchangeTime;
    }

    public String getPrinterInfo() {
        return printerInfo;
    }

    public void setPrinterInfo(String printerInfo) {
        this.printerInfo = printerInfo == null ? null : printerInfo.trim();
    }
}