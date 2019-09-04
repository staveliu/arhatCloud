package com.newer.domain;

import java.util.Date;

public class Transaction {
    private Integer transid;

    private Double value;

    private Date createTime;

    private Integer paid;

    private String method;

    private String apiTransaction;

    private Date paidTime;

    public Integer getTransid() {
        return transid;
    }

    public void setTransid(Integer transid) {
        this.transid = transid;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getApiTransaction() {
        return apiTransaction;
    }

    public void setApiTransaction(String apiTransaction) {
        this.apiTransaction = apiTransaction == null ? null : apiTransaction.trim();
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }
}