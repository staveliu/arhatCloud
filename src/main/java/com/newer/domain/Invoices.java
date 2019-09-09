package com.newer.domain;

public class Invoices {
    private Integer invoiceid;

    private Double price;

    private String transId;

    private Integer payed;

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Integer getPayed() {
        return payed;
    }

    public void setPayed(Integer payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "invoiceid=" + invoiceid +
                ", price=" + price +
                ", transId='" + transId + '\'' +
                ", payed=" + payed +
                '}';
    }
}