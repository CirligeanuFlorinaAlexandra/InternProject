
package com.fortech.internship.dao;

import java.util.List;

import com.fortech.internship.dto.CityDTO;
import com.fortech.internship.model.City;
import com.fortech.internship.model.User;


public interface CityDAO {
	
	public void createCity(CityDTO address);
	
	public City getCityById(int id);
	
	public City getCityByName(String name);
	
	public List<City> getAllCities();
	
	public boolean updateCity(City city);
	
	public void deleteCity(int id);

}