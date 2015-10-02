package com.notifiermobile.models;

import com.notifiermobile.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable, IRequestModel {
    private Integer id;
    private String title;
    private String message;
    private Integer type;
    private boolean unRead;
    private Date createDate;

    public Notification() {
    }

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Notification(String title, String message, Integer type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public Notification(String title, String message, Integer type, Date createDate) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.createDate = createDate;
    }

    public String generateJsonString() {
        JSONObject json = new JSONObject();
        if (id != null) {
            json.put("id", id);
        }

        if (title != null) {
            json.put("title", title);
        }

        if (message != null) {
            json.put("message", message);
        }

        if (type != null) {
            json.put("type", type);
        }

        if (createDate != null) {
            json.put("createDate", createDate);
        }

        return json.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isUnRead() {
        return unRead;
    }

    public void setUnRead(boolean unRead) {
        this.unRead = unRead;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
