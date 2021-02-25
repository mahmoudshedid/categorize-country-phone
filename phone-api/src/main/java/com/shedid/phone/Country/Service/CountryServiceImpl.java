package com.shedid.phone.Country.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service(value = "countryService")
public class CountryServiceImpl implements CountryService {

    private final Map<String, String> country;

    @Autowired
    public CountryServiceImpl(Map<String, String> country) {
        this.country = country;

        this.country.put("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
        this.country.put("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
        this.country.put("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
        this.country.put("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
        this.country.put("Uganda", "\\(256\\)\\ ?\\d{9}$");
    }

    @Override
    public Map<String, String> findAllCountry() {
        return this.country;
    }

    @Override
    public String findRegexByName(String name) {
        return this.country.get(name);
    }

    @Override
    public String findCountryByRegex(String regex) {
        return regex;
    }
}
