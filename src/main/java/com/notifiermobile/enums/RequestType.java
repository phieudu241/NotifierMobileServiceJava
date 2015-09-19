package com.notifiermobile.enums;

import com.notifiermobile.utils.APIInterface;

public enum RequestType {

    GET_ALL(APIInterface.GET_URL, "GET"),
    GET(APIInterface.GET_URL, "GET"),
    ADD(APIInterface.ADD_URL, "POST"),
    UPDATE(APIInterface.UPDATE_URL, "PUT"),
    MARK_AS_READ(APIInterface.MARK_AS_READ_URL, "PUT"),
    DELETE(APIInterface.DELETE_URL, "DELETE"),
    AUTHENTICATION(APIInterface.AUTHENTICATION, "POST");

    private String url;
    private String method;

    RequestType(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
