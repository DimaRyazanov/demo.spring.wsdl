package com.example.service.demo.wsdl.repository;

import example.com.services.countries.Country;
import example.com.services.countries.Currency;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CountryRepository {
    private static final Map<String, Country> countries = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        Country country = new Country();
        country.setCurrency(Currency.EUR);
        country.setName("Spain");
        country.setPopulation(6704314);
        country.setCapital("Madrid");
        countries.put("Spain", country);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
