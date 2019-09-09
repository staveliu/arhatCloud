package com.newer.domain;

import com.google.gson.JsonArray;

import java.util.Date;
public class OrderInfo {
    private JsonArray files;
    private Double totalPrice;
    private String createTime;
    private String printTime;
    private Integer status;
    private String printCode;

    public OrderInfo() {
    }

    public JsonArray getFiles() {
        return files;
    }

    public void setFiles(JsonArray files) {
        this.files = files;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrintCode() {
        return printCode;
    }

    public void setPrintCode(String printCode) {
        this.printCode = printCode;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "files=" + files +
                ", totalPrice=" + totalPrice +
                ", createTime=" + createTime +
                ", printTime=" + printTime +
                ", status=" + status +
                ", printCode='" + printCode + '\'' +
                '}';
    }
}
