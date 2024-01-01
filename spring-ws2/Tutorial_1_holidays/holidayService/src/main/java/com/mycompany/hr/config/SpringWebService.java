package com.mycompany.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@Configuration
public class SpringWebService {
//    @Bean
//    public DefaultWsdl11Definition holiday() {
//        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
//        definition.setPortTypeName("HumanResource");
//        definition.setLocationUri("http://localhost:8080/holidayService/");
//        definition.setSchema(new SimpleXsdSchema(new ClassPathResource("hr.xsd")));
//
//        return definition;
//    }

    @Bean
    public DefaultWsdl11Definition holiday() {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("HumanResource");
        definition.setLocationUri("/holidayService/");
        definition.setTargetNamespace("http://mycompany.com/hr/definitions");
        definition.setSchemaCollection(holidayXsd());
        return definition;
    }

    @Bean
    public CommonsXsdSchemaCollection holidayXsd() {
        CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection(new ClassPathResource("/hr.xsd"));
        collection.setInline(true);
        return collection;
    }


}
