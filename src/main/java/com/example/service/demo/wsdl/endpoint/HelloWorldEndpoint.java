package com.example.service.demo.wsdl.endpoint;

import example.com.services.demowsdl.Greeting;
import example.com.services.demowsdl.ObjectFactory;
import example.com.services.demowsdl.Person;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class HelloWorldEndpoint {

    @PayloadRoot(
            namespace = "http://com.example/services/demowsdl",
            localPart = "person"
    )
    @ResponsePayload
    public Greeting sayHello(@RequestPayload Person request) {
        String greeting = "Hello " + request.getFirstName() + " "
                + request.getLasName() + "!";

        ObjectFactory factory = new ObjectFactory();
        Greeting response = factory.createGreeting();
        response.setGreeting(greeting);

        return response;
    }
}
