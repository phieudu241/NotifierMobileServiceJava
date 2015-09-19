package com.notifiermobile.exception;

public class RequestException extends RuntimeException {
    private int httpStatus = -1;
    private String errorMessage;

    public RequestException(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public RequestException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public RequestException(int httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
