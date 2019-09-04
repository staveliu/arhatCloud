package com.newer.domain;

import java.util.Date;

public class Files {
    private Integer fid;

    private Integer uid;

    private String fileName;

    private Double fileSize;

    private String filePage;

    private String url;

    private Date uploadTime;

    private Date expireTime;

    private Integer status;

    private Integer printed;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePage() {
        return filePage;
    }

    public void setFilePage(String filePage) {
        this.filePage = filePage == null ? null : filePage.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrinted() {
        return printed;
    }

    public void setPrinted(Integer printed) {
        this.printed = printed;
    }
}