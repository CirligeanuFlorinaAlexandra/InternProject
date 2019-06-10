package com.fortech.internship.service.impl.mapper;

import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.CityDTO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.Address;
import com.fortech.internship.model.City;
import com.fortech.internship.model.Faculty;
import com.fortech.internship.model.University;
import com.fortech.internship.model.User;

public class ToDTO {
	public static AddressDTO address(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(address.getId());
		addressDTO.setPostalCode(address.getPostalCode());
		return addressDTO;
	}

	public static CityDTO city(City city) {
		CityDTO cityDTO = new CityDTO();
		cityDTO.setId(city.getId());
		cityDTO.setName(city.getName());
		cityDTO.setAddressDTO(address(city.getAddress()));
		return cityDTO;
	}

	public static UniversityDTO university(University university) {
		UniversityDTO universityDTO = new UniversityDTO();
		universityDTO.setId(university.getId());
		universityDTO.setName(university.getName());
		universityDTO.setCityDTO(city(university.getCity()));
		return universityDTO;
	}

	public static FacultyDTO faculty(Faculty faculty) {
		FacultyDTO facultyDTO = new FacultyDTO();
		facultyDTO.setId(faculty.getId());
		facultyDTO.setName(faculty.getName());
		facultyDTO.setUniversityDTO(university(faculty.getUniversity()));
		facultyDTO.setAddressDto(address(faculty.getAddress()));
		return facultyDTO;
	}

	public static UserDTO user(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setApproved(user.getApproved());
		userDTO.setAccessLevel(user.getAccessLevel());
		userDTO.setFacultyDTO(faculty(user.getFaculty()));
		userDTO.setAddressDTO(address(user.getAddress()));
		return userDTO;
	}
}