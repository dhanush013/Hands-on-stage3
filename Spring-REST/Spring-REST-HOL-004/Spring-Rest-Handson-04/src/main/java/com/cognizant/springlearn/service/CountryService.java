package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.exception.CountryNotFoundException;

@Service
public class CountryService {

	Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static List<Country> countries=new ArrayList<>();

	
	
	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("START");
		countries = (List<Country>) context.getBean("countryList");
		LOGGER.info("Calling CountryService.getCountry() with code="+code);
		Country country = countries.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
		LOGGER.debug("Country: {}", country);
		if(country == null) {
			throw new CountryNotFoundException();
		}
		LOGGER.info("END");
		return country;
	}

	public void addCountry(@Valid Country country) {
		countries.add(country);
		
	}

	public List<Country> getAllCountries() {
		countries = (List<Country>) context.getBean("countryList");
		return countries;
	}

	public void updateCountry(String id, Country country) throws CountryNotFoundException {
		deleteCountry(id);
		addCountry(country);
	}

	public void deleteCountry(String id) throws CountryNotFoundException {
		Country found_country = getCountry(id);
		countries.remove(found_country);
		
	}
}
