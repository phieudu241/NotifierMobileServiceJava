package com.notifiermobile.models;

import com.notifiermobile.json.JSONObject;

public class UpdateModel implements IRequestModel {
    public String title;
    public String message;
    public Integer type;
    public Boolean unRead;

    public String generateJsonString() {
        JSONObject json = new JSONObject();
        if (title != null) {
            json.put("Title", title);
        }

        if (message != null) {
            json.put("Message", message);
        }

        if (type != null) {
            json.put("type", type);
        }

        if (unRead != null) {
            json.put("unRead", unRead.booleanValue());
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

    public Boolean getUnRead() {
        return unRead;
    }

    public void setUnRead(Boolean unRead) {
        this.unRead = unRead;
    }
}
