package ru.unibell.clientsandcontactsapi.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final ApiError apiError;

    public BaseException(HttpStatus httpStatus, ApiError apiError) {
        super(apiError.getDescription());
        this.httpStatus = httpStatus;
        this.apiError = apiError;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
