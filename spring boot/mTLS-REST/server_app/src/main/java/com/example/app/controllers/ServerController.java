package com.example.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/server")
public class ServerController {

    @GetMapping
    public String helloServer() {
        log.info("calling server application");
        return "Hello, I am the server!";
    }

}
