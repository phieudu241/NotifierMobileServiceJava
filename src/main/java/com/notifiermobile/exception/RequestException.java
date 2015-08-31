package com.notifiermobile.exception;

public class RequestException extends RuntimeException {
    private int statusCode = -1;
    private String errorMessage;

    public RequestException(int statusCode) {
        this.statusCode = statusCode;
    }

    public RequestException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RequestException(int statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
