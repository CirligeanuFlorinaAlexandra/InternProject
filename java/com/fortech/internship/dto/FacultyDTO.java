package com.fortech.internship.dto;

import com.fortech.internship.model.Faculty;

public class FacultyDTO {
	private int id;
	private String name;
	private UniversityDTO universityDTO;
	private AddressDTO addressDto;

	public FacultyDTO() {
	}

	public FacultyDTO(String name, UniversityDTO universityDTO) {
		super();
		this.name = name;
		this.universityDTO = universityDTO;
	}

	public FacultyDTO(Faculty faculty) {
		this.name = faculty.getName();
		this.universityDTO = new UniversityDTO(faculty.getUniversity());
		this.id = faculty.getId();
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

	public UniversityDTO getUniversityDTO() {
		return universityDTO;
	}

	public void setUniversityDTO(UniversityDTO universityDTO) {
		this.universityDTO = universityDTO;
	}

	public AddressDTO getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDTO addressDto) {
		this.addressDto = addressDto;
	}
}