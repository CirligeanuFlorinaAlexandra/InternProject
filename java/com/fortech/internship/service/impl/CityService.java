package com.fortech.internship.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dao.CityDAO;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.CityDTO;
import com.fortech.internship.model.City;
import com.fortech.internship.service.impl.mapper.ToDTO;
import com.fortech.internship.service.impl.mapper.ToEntity;

@Service
public class CityService {

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private CityDAO cityDAO;

	@Transactional(readOnly = false)
	public void createCity(CityDTO cityDTO) {
		cityDAO.createCity(ToEntity.city(cityDTO));
	}

	@Transactional(readOnly = true)
	public CityDTO getCityById(int id) {
		CityDTO c = ToDTO.city(cityDAO.getCityById(id));

		return c;
	}

	@Transactional(readOnly = true)
	public List<CityDTO> getAllCities() {
		List<City> cities = cityDAO.getAllCities();
		List<CityDTO> citiesDTOs = new ArrayList<>();

		for (City city : cities) {
			citiesDTOs.add(ToDTO.city(city));
		}

		return citiesDTOs;
	}

	@Transactional(readOnly = false)
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

	@Transactional(readOnly = false)
	public void deleteCity(int id) {
		cityDAO.deleteCity(id);
	}
}