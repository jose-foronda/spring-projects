package com.example.app.client;

import com.example.app.configuration.AppClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "serverApiService", url = "${feign.server-api.url}", configuration = AppClientConfig.class)
public interface ServerClient {

    @PostMapping(value = "/api/v1/server", consumes = APPLICATION_JSON_VALUE)
    String helloServer();

}