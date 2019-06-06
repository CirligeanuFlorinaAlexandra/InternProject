package com.fortech.internship.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.fortech.internship.dao.CityDAO;
import com.fortech.internship.dao.UniversityDAO;
import com.fortech.internship.dao.UniversityDAOImpl;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.University;
import com.fortech.internship.model.User;
import com.fortech.internship.dto.CityDTO;


@Service

public class UniversityService {
	
	@Autowired
	private UniversityDAO universityDAO;
	
	@Autowired
	private CityDAO cityDAO;

	
	@Transactional
	public void createUniversity(UniversityDTO universityDTO) {
		universityDAO.createUniversity(universityDTO);
	}
	
	@Transactional
	public University getUniversityById(int id) {
		University university = universityDAO.getUniversityById(id);
		return university;
    }
	
	@Transactional
	public List<UniversityDTO> getAllUniversities() {
		List<University> universities = universityDAO.getAllUniversities();
		List<UniversityDTO> universitiesDTO = new ArrayList<>();
		
		for (University university : universities) {
			universitiesDTO.add(new UniversityDTO(university));
		}
		return universitiesDTO;
    }
	
	@Transactional
	public boolean updateUniversity(UniversityDTO universityDTO) {
		University university = null;
		if (universityDTO.getId() != 0) {
			university = universityDAO.getUniversityById(universityDTO.getId());
		} else {
			university = (University) universityDAO.getUniversityByName(universityDTO.getName());
		}
		if (university != null) {
			university.setName(universityDTO.getName());
			CityDTO cityDTO = universityDTO.getCityDTO();
			university.setCity(cityDAO.getCityById(cityDTO.getId()));
		}
		return universityDAO.updateUniversity(university);
	}

	@Transactional
	public void deleteUniversity(int id) {
        universityDAO.deleteUniversity(id);
    }
	
}