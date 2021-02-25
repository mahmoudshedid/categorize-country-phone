package com.shedid.phone.Country.Service;

import java.util.Map;

public interface CountryService {

    Map<String, String> findAllCountry();

    String findRegexByName(String name);

    String findCountryByRegex(String regex);
}
