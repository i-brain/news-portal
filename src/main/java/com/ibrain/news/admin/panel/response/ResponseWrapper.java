package com.ibrain.news.admin.panel.response;


public class ResponseWrapper<T> {

    private boolean success;
    private String message;
    private T data;

    public ResponseWrapper(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}