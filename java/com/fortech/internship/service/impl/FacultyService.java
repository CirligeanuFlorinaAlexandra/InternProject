package com.fortech.internship.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dao.FacultyDAO;
import com.fortech.internship.dto.AddressDTO;

import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UniversityDTO;

import com.fortech.internship.model.Faculty;

import com.fortech.internship.service.impl.mapper.ToDTO;
import com.fortech.internship.service.impl.mapper.ToEntity;
import com.fortech.internship.dao.UniversityDAO;

@Service
public class FacultyService {

	@Autowired
	private UniversityDAO universityDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private FacultyDAO facultyDAO;

	@Transactional(readOnly = false)
	public void createFaculty(FacultyDTO facultyDTO) {

		facultyDAO.createFaculty(ToEntity.faculty(facultyDTO));
	}

	@Transactional(readOnly = true)
	public FacultyDTO getFacultyById(int id) {
		FacultyDTO f = ToDTO.faculty(facultyDAO.getFacultyById(id));

		return f;
	}

	@Transactional(readOnly = true)
	public List<FacultyDTO> getFacultiesByUniversityName(String name) {
		List<Faculty> faculties = facultyDAO.getFacultiesByUniversityName(name);
		List<FacultyDTO> facultiesDTO = new ArrayList<>();

		for (Faculty faculty : faculties) {
			facultiesDTO.add(ToDTO.faculty(faculty));
		}

		return facultiesDTO;
	}

	@Transactional(readOnly = true)
	public List<FacultyDTO> getFacultiesByCityName(String name) {
		List<Faculty> faculties = facultyDAO.getFacultiesByCityName(name);
		List<FacultyDTO> facultiesDTO = new ArrayList<>();
		for (Faculty faculty : faculties) {
			facultiesDTO.add(ToDTO.faculty(faculty));
		}

		return facultiesDTO;
	}

	@Transactional(readOnly = true)
	public List<FacultyDTO> getAllFaculties() {
		List<Faculty> faculties = new ArrayList<>();
		List<FacultyDTO> facultiesDTOs = new ArrayList<>();

		for (Faculty faculty : faculties) {
			facultiesDTOs.add(ToDTO.faculty(faculty));
		}

		return facultiesDTOs;
	}

	@Transactional(readOnly = false)
	public boolean updateFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = null;

		if (facultyDTO.getId() != 0) {
			faculty = facultyDAO.getFacultyById(facultyDTO.getId());
		} else {
			faculty = (Faculty) facultyDAO.getFacultyByName(facultyDTO
					.getName());
		}

		if (faculty != null) {
			AddressDTO addressDTO = facultyDTO.getAddressDto();
			UniversityDTO universityDTO = facultyDTO.getUniversityDTO();

			faculty.setName(facultyDTO.getName());
			faculty.setAddress(addressDAO.getAddressById(addressDTO.getId()));
			faculty.setUniversity(universityDAO.getUniversityById(universityDTO
					.getId()));
		}

		return facultyDAO.updateFaculty(faculty);
	}

	@Transactional(readOnly = false)
	public void deleteFaculty(int id) {
		facultyDAO.deleteFaculty(id);
	}
}