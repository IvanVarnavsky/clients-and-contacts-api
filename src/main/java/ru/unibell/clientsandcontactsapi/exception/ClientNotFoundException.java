package ru.unibell.clientsandcontactsapi.exception;

import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends BaseException {
    public ClientNotFoundException(int clientId) {
        super(HttpStatus.NOT_FOUND, new ApiError(404, String.format("Client not found with id=%d", clientId)));
    }
}
