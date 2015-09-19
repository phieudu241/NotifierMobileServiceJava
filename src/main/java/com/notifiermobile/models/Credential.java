package com.notifiermobile.models;

import com.notifiermobile.json.JSONObject;

public class Credential implements IRequestModel {
    public String username;
    public String password;

    public Credential() { }

    public Credential(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String generateJsonString()
    {
        JSONObject json = new JSONObject();
        json.put("Username", username);
        json.put("Password", password);
        json.put("isGetSecretKey", true);
        return json.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
