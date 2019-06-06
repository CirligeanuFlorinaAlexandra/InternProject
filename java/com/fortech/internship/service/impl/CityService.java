package com.fortech.internship.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dao.CityDAO;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.CityDTO;

import com.fortech.internship.model.Address;
import com.fortech.internship.model.City;
import com.fortech.internship.model.User;


@Service

public class CityService {
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private CityDAO cityDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void createCity(CityDTO cityDTO) {
		//cityDAO.createCity(cityDTO);
		Session session = sessionFactory.getCurrentSession();
		City city = new City();
		city.setName(cityDTO.getName());
		city.setAddress(sessionFactory.getCurrentSession().get(Address.class, cityDTO.getAddressDTO().getId()));
		session.save(city);	
	}

	@Transactional
	public City getCityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		City city = session.get(City.class, id);
		CityDTO cityDTO = new CityDTO(city);
		return city;
	}

	@Transactional
	public List<CityDTO> getAllCities() {
		//return cityDAO.getAllCities();
		List<City> cities = cityDAO.getAllCities();
		List<CityDTO> citiesDTO = new ArrayList<>();
		for (City city : cities) {
			citiesDTO.add(new CityDTO(city));
		}
		return citiesDTO;
	}

	@Transactional
	public boolean updateCity(CityDTO cityDTO) {
		
		City city = null;
		if (cityDTO.getId() != 0) {
			city = cityDAO.getCityById(cityDTO.getId());
		} else {
			city = (City) cityDAO.getCityByName(cityDTO.getName());
		}

		if (city != null) {

			city.setName(cityDTO.getName());
			AddressDTO addressDTO = cityDTO.getAddressDTO();
			city.setAddress(addressDAO.getAddressById(addressDTO.getId()));
		}
		return cityDAO.updateCity(city);
	}

	@Transactional
	public void deleteCity(int id) {
		cityDAO.deleteCity(id);
	}
}