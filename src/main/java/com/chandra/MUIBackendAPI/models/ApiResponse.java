package com.chandra.MUIBackendAPI.models;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private boolean success;
    private LocalDateTime timestamp;
    private T data;
    private String errorDetails;

    // Constructor for successful response
    public ApiResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.success = true;
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.errorDetails = null; // No error in success response
    }

    // Constructor for error response
    public ApiResponse(int statusCode, String message, String errorDetails) {
        this.statusCode = statusCode;
        this.message = message;
        this.success = false;
        this.timestamp = LocalDateTime.now();
        this.data = null; // No data in error response
        this.errorDetails = errorDetails;
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
