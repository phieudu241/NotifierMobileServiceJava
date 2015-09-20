package com.notifiermobile.exception;

public class NotificationException extends RuntimeException {
    private int httpStatus = -1;
    private String errorMessage;

    public NotificationException(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public NotificationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public NotificationException(int httpStatus, String errorMessage) {
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
