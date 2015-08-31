package com.notifiermobile.models;

/**
 * Created by Administrator on 8/26/15.
 */
public class DeleteModel extends Authentication {

    public DeleteModel() { }

    public DeleteModel(String username, String secretKey)
    {
        this.username = username;
        this.secretKey = secretKey;
    }
}
