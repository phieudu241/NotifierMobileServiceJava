package com.notifiermobile.models;

import com.notifiermobile.json.JSONObject;

public class GetModel implements IRequestModel {
    public String username;
    public String secretKey;
    public int type = -1;
    public boolean unRead;

    public GetModel() {
    }

    public GetModel(String username, String secretKey) {
        this.username = username;
        this.secretKey = secretKey;
    }

    public GetModel(String username, String secretKey, int type) {
        this.username = username;
        this.secretKey = secretKey;
        this.type = type;
    }

    public GetModel(String username, String secretKey, int type, boolean unread) {
        this.username = username;
        this.secretKey = secretKey;
        this.type = type;
        this.unRead = unread;
    }

    public String generateJsonString() {
        JSONObject json = new JSONObject();
        json.put("Username", username);
        json.put("SecretKey", secretKey);
        if (type != -1)
        {
            json.put("type", type);
        }

        if (unRead)
        {
            json.put("unRead", unRead);
        }

        return json.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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
}
