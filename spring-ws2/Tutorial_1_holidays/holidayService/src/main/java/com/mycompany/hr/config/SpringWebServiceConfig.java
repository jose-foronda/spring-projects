package com.mycompany.hr.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
public class SpringWebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/holidayService/*");
    }

    @Bean(name = "holiday")
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
