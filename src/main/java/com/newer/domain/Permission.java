package com.newer.domain;

public class Permission {
    private Integer pid;

    private String pname;

    private String accessApi;

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

    public String getAccessApi() {
        return accessApi;
    }

    public void setAccessApi(String accessApi) {
        this.accessApi = accessApi == null ? null : accessApi.trim();
    }
}