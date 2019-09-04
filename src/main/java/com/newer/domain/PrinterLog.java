package com.newer.domain;

import java.util.Date;

public class PrinterLog {
    private Integer id;

    private Integer printid;

    private Integer taskid;

    private String status;

    private Date printTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrintid() {
        return printid;
    }

    public void setPrintid(Integer printid) {
        this.printid = printid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }
}