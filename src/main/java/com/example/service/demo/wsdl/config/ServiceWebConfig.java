package com.example.service.demo.wsdl.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.Servlet;

@EnableWs
@Configuration
public class ServiceWebConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<Servlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "helloworld")
    public Wsdl11Definition helloWorldWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("helloworld.wsdl"));

        return wsdl11Definition;
    }

    @Bean(name = "countries")
    public Wsdl11Definition countriesWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws/countries");
        wsdl11Definition.setTargetNamespace("http://com.example/services/countries");
        wsdl11Definition.setSchema(countriesSchema());

        return wsdl11Definition;
    }

    @Bean(name = "books")
    public Wsdl11Definition booksWsdl11Definition() {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("BooksPort");
        definition.setLocationUri("/ws/books");
        definition.setTargetNamespace("http://com.example/services/books");
        definition.setSchema(booksSchema());

        return definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    @Bean
    public XsdSchema booksSchema() {
        return new SimpleXsdSchema(new ClassPathResource("books.xsd"));
    }
}
