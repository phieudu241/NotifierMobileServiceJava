package com.notifiermobile.models;

import com.notifiermobile.json.JSONObject;

import java.util.Date;

public class AddModel implements IRequestModel {
    private String title;
    private String message;
    private Integer type;
    private Date createDate;

    public AddModel() {
    }

    public AddModel(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public AddModel(String title, String message, Integer type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public AddModel(String title, String message, Integer type, Date createDate) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.createDate = createDate;
    }

    public String generateJsonString() {
        JSONObject json = new JSONObject();
        json.put("Title", title);
        json.put("Message", message);

        if (type != null) {
            json.put("type", type);
        }

        if (createDate != null) {
            json.put("CreateDate", createDate);
        }

        return json.toString();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
