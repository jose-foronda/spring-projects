package com.example.app.controllers;

import com.example.app.client.ServerClient;
import com.example.app.configuration.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ServerClient serverClient;
    private final MyService myService;

    @PostMapping
    public String greetServer() {
        log.info("calling client application");
//        String serverResponse = serverClient.helloServer();
//        String serverResponse = "H";
        String serverResponse = myService.greetTheServer();
        log.info("client response {}", serverResponse);
        return serverResponse;
    }

}
