package com.example.service.demo.wsdl.endpoint;

import com.example.service.demo.wsdl.repository.CountryRepository;
import example.com.services.countries.GetCountryRequest;
import example.com.services.countries.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private CountryRepository countryRepository;


    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @PayloadRoot(namespace = "http://com.example/services/countries", localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
