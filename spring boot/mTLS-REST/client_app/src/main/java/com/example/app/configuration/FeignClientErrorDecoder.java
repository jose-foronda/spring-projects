package com.example.app.configuration;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;

import static org.springframework.http.HttpStatus.valueOf;

public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    @SneakyThrows
    public Exception decode(String methodKey, Response response) {

        return switch (response.status()) {
            case 400 -> new ServerApiException("400 " + response.reason());
            case 404 -> new ServerApiException("404 Not Found Url");
            case 401 -> new ServerApiException("401 Unauthorized. Token is incorrect/invalid");
            default -> new ServerApiException(valueOf(response.status()) + response.reason());
        };
    }


}
