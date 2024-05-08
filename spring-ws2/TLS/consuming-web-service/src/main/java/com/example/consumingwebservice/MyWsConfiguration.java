//package com.example.consumingwebservice;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.ws.config.annotation.EnableWs;
//import org.springframework.ws.config.annotation.WsConfigurerAdapter;
//import org.springframework.ws.server.EndpointInterceptor;
//import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
//
//import java.util.List;
//
//@Configuration
//@EnableWs
//public class MyWsConfiguration extends WsConfigurerAdapter {
//
//    private final Wss4jSecurityInterceptor wss4jSecurityInterceptor;
//
//    public MyWsConfiguration(Wss4jSecurityInterceptor wss4jSecurityInterceptor) {
//        this.wss4jSecurityInterceptor = wss4jSecurityInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(List<EndpointInterceptor> interceptors) {
//        interceptors.add(wss4jSecurityInterceptor);
//    }
//
//}
