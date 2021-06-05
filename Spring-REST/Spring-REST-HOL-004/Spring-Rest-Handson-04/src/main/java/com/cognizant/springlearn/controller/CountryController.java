package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
@RestController
public class CountryController {
	
	@Autowired
	
	CountryService service;
	
	private static final Logger logger=LoggerFactory.getLogger("CountryController.class");
	ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
	
	@RequestMapping("/country")
	public Country getCountryIndia()
	{
		logger.info("Start");
		Country country=context.getBean("in",Country.class);
		logger.info("End");
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		logger.info("Start");
//		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		List<Country> list=service.getAllCountries();
		logger.info("End");
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		logger.info("START");
		logger.info("END");
		return service.getCountry(code);
	}
	@PostMapping("/countries")
	public void addCountry(@Valid @RequestBody Country country) {
		logger.info("START");
		this.service.addCountry(country);
		logger.debug("Added {}", country);
		logger.info("END");
		
	}
	
	@PutMapping(value = "/update/{id}")
	public void updateCountry(@PathVariable("id") String id, @RequestBody Country country)
			throws CountryNotFoundException {
		service.updateCountry(id, country);
		}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteCountry(@PathVariable("id") String id) throws CountryNotFoundException {

		service.deleteCountry(id);

		
	}

}
