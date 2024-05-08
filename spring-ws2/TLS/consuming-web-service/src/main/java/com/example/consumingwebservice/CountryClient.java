
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryResponse getCountry(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("https://localhost:8081/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		log.info("response name: {}", response.getCountry().getName());
		log.info("response capital: {}", response.getCountry().getCapital());
		log.info("response population: {}", response.getCountry().getPopulation());
		log.info("response currency: {}", response.getCountry().getCurrency());
		return response;
	}

}
