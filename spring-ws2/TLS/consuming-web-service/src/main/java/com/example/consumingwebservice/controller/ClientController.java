package com.example.consumingwebservice.controller;

import com.example.consumingwebservice.CountryClient;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/spring-ws/client")
public class ClientController {

    private final CountryClient countryClient;
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);


    public ClientController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping
    public GetCountryResponse greetServer() {
        log.info("calling client application");
        String country = "Spain";
        GetCountryResponse response = countryClient.getCountry(country);
        System.err.println(response.getCountry().getCurrency());
        return response;
    }

}
