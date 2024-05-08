
package com.example.consumingwebservice;

import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import java.util.List;

@Configuration
public class CountryConfiguration {

//	private final Wss4jSecurityInterceptor wss4jSecurityInterceptor;
//
//	public CountryConfiguration(Wss4jSecurityInterceptor wss4jSecurityInterceptor) {
//		this.wss4jSecurityInterceptor = wss4jSecurityInterceptor;
//	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.consumingwebservice.wsdl");
		return marshaller;
	}

	@Bean
	public CountryClient countryClient(Jaxb2Marshaller marshaller, SslBundles sslBundles) {
		SslBundle sslBundle = sslBundles.getBundle("mybundle");

		var messageSender = new HttpsUrlConnectionMessageSender();
		messageSender.setKeyManagers(sslBundle.getManagers().getKeyManagers());
		messageSender.setTrustManagers(sslBundle.getManagers().getTrustManagers());


		CountryClient client = new CountryClient();
		client.setDefaultUri("https://localhost:8081/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
//		var list = new ClientInterceptor[] {wss4jSecurityInterceptor};
//		client.setInterceptors(list);
		client.setMessageSender(messageSender);
		return client;
	}

}
