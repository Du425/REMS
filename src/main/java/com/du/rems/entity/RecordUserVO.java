package com.du.rems.entity;

import java.io.Serializable;

public class RecordUserVO implements Serializable {

    private Integer rid;

    private String remarks;

    private Integer id;

    private String username;

    private Integer userId;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RecordUserVO{" +
                "rid=" + rid +
                ", remarks='" + remarks + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", userId=" + userId +
                '}';
    }
}
