package com.example.app.configuration;

public class ServerApiException extends RuntimeException {

    public ServerApiException(String statusMessage) {
        super(statusMessage);
    }
}
