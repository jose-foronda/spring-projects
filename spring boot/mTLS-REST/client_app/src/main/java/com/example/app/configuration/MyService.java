package com.example.app.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MyService {

    private final RestTemplate restTemplate;

    public MyService(RestTemplateBuilder restTemplateBuilder, SslBundles sslBundles) {
        this.restTemplate = restTemplateBuilder.setSslBundle(sslBundles.getBundle("mybundle")).build();
    }

    @Value("${server-api.url}")
    private String route;

    public String greetTheServer() {
        return this.restTemplate.getForObject(route + "/api/v1/server", String.class);
    }

}
