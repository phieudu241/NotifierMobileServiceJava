package com.notifiermobile.models;

/**
 * Created by Administrator on 8/26/15.
 */
public class MarkAsReadModel extends Authentication {

    public MarkAsReadModel() { }

    public MarkAsReadModel(String username, String secretKey)
    {
        this.username = username;
        this.secretKey = secretKey;
    }
}
