package ru.unibell.clientsandcontactsapi.exception;

public class ApiError {
    private final int errorCode;
    private final String description;

    public ApiError(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
