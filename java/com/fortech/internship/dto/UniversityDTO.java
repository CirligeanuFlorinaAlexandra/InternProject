package com.fortech.internship.dto;

import com.fortech.internship.model.University;
import com.fortech.internship.service.impl.mapper.ToDTO;

public class UniversityDTO {
	private int id;
	private String name;
	private CityDTO cityDTO;

	public UniversityDTO() {
	}

	public UniversityDTO(String name, CityDTO cityDTO) {
		super();
		this.name = name;
		this.cityDTO = cityDTO;
	}

	public UniversityDTO(University university) {
		this.name = university.getName();
		this.cityDTO = ToDTO.city(university.getCity());
		this.id = university.getId();
	}

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
