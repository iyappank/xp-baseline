package com.products.exception;

import java.time.OffsetDateTime;

public class ApiError {
    private String message;
    private String path;
    private int status;
    private OffsetDateTime timestamp;

    public ApiError(String message, String path, int status) {
        this.message = message;
        this.path = path;
        this.status = status;
        this.timestamp = OffsetDateTime.now();
    }

    public String getMessage() { return message; }
    public String getPath() { return path; }
    public int getStatus() { return status; }
    public OffsetDateTime getTimestamp() { return timestamp; }
}