//package com.example.consumingwebservice;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileUrlResource;
//import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
//import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;
//
//import java.io.IOException;
//
//@Configuration
//public class Wss4jSecurityInterceptorConfig {
//
//    @Value("${spring.ssl.bundle.jks.mybundle.keystore.password}")
//    private String keyStorePassword;
//
//    @Value("${spring.ssl.bundle.jks.mybundle.keystore.location}")
//    private String keyStoreLocation;
//
//    @Bean
//    public Wss4jSecurityInterceptor wss4jSecurityInterceptor(CryptoFactoryBean cryptoFactoryBean) throws Exception {
//        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
//        wss4jSecurityInterceptor.setSecurementActions("Signature");
//        wss4jSecurityInterceptor.setSecurementUsername("keystore-client");
//        wss4jSecurityInterceptor.setSecurementPassword(keyStorePassword);
////        wss4jSecurityInterceptor.setSecurementEncryptionUser("keystore-client");
//        wss4jSecurityInterceptor.setSecurementSignatureKeyIdentifier("DirectReference");
//        wss4jSecurityInterceptor.setSecurementSignatureCrypto(cryptoFactoryBean.getObject());
////        wss4jSecurityInterceptor.setSecurementEncryptionCrypto(cryptoFactoryBean.getObject());
////        wss4jSecurityInterceptor.setSecurementUsername("mycert");
//
//        wss4jSecurityInterceptor.setValidationActions("Signature");
//        wss4jSecurityInterceptor.setValidationSignatureCrypto(cryptoFactoryBean().getObject());
////        wss4jSecurityInterceptor.setValidationDecryptionCrypto(cryptoFactoryBean.getObject());
//        return wss4jSecurityInterceptor;
//    }
//
//    @Bean
//    public CryptoFactoryBean cryptoFactoryBean() throws IOException {
////        org.apache.xml.security.Init.init();
//        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
//        cryptoFactoryBean.setKeyStorePassword(keyStorePassword);
//        cryptoFactoryBean.setKeyStoreLocation(new FileUrlResource(getClass().getClassLoader().getResource("keystore-client.p12")));
//        return cryptoFactoryBean;
//    }
//
//}
