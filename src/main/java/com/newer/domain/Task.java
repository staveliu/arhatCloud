package com.newer.domain;

import java.util.Date;

public class Task {
    private Integer taskid;

    private Integer uid;

    private Integer invoiceid;

    private String printcode;

    private Integer color;

    private String status;

    private Integer printid;

    private Integer transid;

    private Date createTime;

    private Date printTime;

    private Double price;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getPrintcode() {
        return printcode;
    }

    public void setPrintcode(String printcode) {
        this.printcode = printcode == null ? null : printcode.trim();
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getPrintid() {
        return printid;
    }

    public void setPrintid(Integer printid) {
        this.printid = printid;
    }

    public Integer getTransid() {
        return transid;
    }

    public void setTransid(Integer transid) {
        this.transid = transid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}