package com.fortech.internship.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.internship.dto.CityDTO;
import com.fortech.internship.model.City;

import com.fortech.internship.service.impl.CityService;
import com.fortech.internship.service.impl.mapper.ToEntity;

@RestController
@RequestMapping(value="/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	/*** Creating a new City ***/
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createCity(@RequestBody CityDTO cityDTO) {
				cityService.createCity(cityDTO);		
	}

	/*** Retrieve a single City ***/
	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public City getCityById(@PathVariable("id") int id) {
		City address = ToEntity.city(cityService.getCityById(id));
		return address;
	}

	/*** Retrieve all Cities ***/
	@RequestMapping(value = "/all", produces =  { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public List<CityDTO> getAllCities() {
		return (List<CityDTO>) cityService.getAllCities();
	}

	/*** Update an City ***/
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateCity(@RequestBody CityDTO cityDTO) {
		boolean updatedCity = cityService.updateCity(cityDTO);
		System.out.println(updatedCity);
	}

	/*** Delete an City ***/
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteAddress(@PathVariable("id") int id) {
		cityService.deleteCity(id);
	}
}