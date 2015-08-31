package com.notifiermobile.models;

import com.notifiermobile.json.JSONObject;

public class Authentication implements IRequestModel {
    public String username;
    public String secretKey;

    public Authentication() { }

    public Authentication(String username, String secretKey)
    {
        this.username = username;
        this.secretKey = secretKey;
    }

    public String generateJsonString()
    {
        JSONObject json = new JSONObject();
        json.put("Username", username);
        json.put("SecretKey", secretKey);
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
}
