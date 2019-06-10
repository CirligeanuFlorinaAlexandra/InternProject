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

public class ToEntity {
	public static Address address(AddressDTO addressDTO) {
		Address address = new Address();
		address.setId(addressDTO.getId());
		address.setPostalCode(addressDTO.getPostalCode());
		return address;
	}

	public static City city(CityDTO cityDTO) {
		City city = new City();
		city.setId(cityDTO.getId());
		city.setName(cityDTO.getName());
		city.setAddress(address(cityDTO.getAddressDTO()));
		return city;
	}

	public static University university(UniversityDTO universityDTO) {
		University university = new University();
		university.setId(universityDTO.getId());
		university.setName(universityDTO.getName());
		university.setCity(ToEntity.city(universityDTO.getCityDTO()));
		return university;
	}

	public static Faculty faculty(FacultyDTO facultyDTO) {
		Faculty faculty = new Faculty();
		faculty.setId(facultyDTO.getId());
		faculty.setName(facultyDTO.getName());
		faculty.setUniversity(university(facultyDTO.getUniversityDTO()));
		faculty.setAddress(ToEntity.address(facultyDTO.getAddressDto()));
		return faculty;
	}

	public static User user(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setApproved(userDTO.getApproved());
		user.setAccesLevel(userDTO.getAccessLevel());
		user.setFaculty(ToEntity.faculty(userDTO.getFacultyDTO()));
		user.setAddress(ToEntity.address(userDTO.getAddressDTO()));
		return user;
	}

}