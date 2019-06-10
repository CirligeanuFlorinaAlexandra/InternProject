package com.fortech.internship.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dao.CityDAO;
import com.fortech.internship.dao.UniversityDAO;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.model.University;
import com.fortech.internship.service.impl.mapper.ToDTO;
import com.fortech.internship.service.impl.mapper.ToEntity;
import com.fortech.internship.dto.CityDTO;

@Service
public class UniversityService {

	@Autowired
	private UniversityDAO universityDAO;

	@Autowired
	private CityDAO cityDAO;

	@Transactional(readOnly = false)
	public void createUniversity(UniversityDTO universityDTO) {
		universityDAO.createUniversity(ToEntity.university(universityDTO));
	}
	
	@Transactional(readOnly = true)
	public UniversityDTO getUniversityById(int id) {
		UniversityDTO u = ToDTO.university(universityDAO.getUniversityById(id));
		return u;
	}

	@Transactional(readOnly = true)
	public List<UniversityDTO> getAllUniversities() {
		List<University> universities = universityDAO.getAllUniversities();
		List<UniversityDTO> universitiesDTO = new ArrayList<>();

		for (University university : universities) {
			universitiesDTO.add(ToDTO.university(university));
		}
		return universitiesDTO;
	}

	@Transactional(readOnly = false)
	public boolean updateUniversity(UniversityDTO universityDTO) {
		University university = null;
		if (universityDTO.getId() != 0) {
			university = universityDAO.getUniversityById(universityDTO.getId());
		} else {
			university = (University) universityDAO
					.getUniversityByName(universityDTO.getName());
		}
		if (university != null) {
			university.setName(universityDTO.getName());
			CityDTO cityDTO = universityDTO.getCityDTO();
			university.setCity(cityDAO.getCityById(cityDTO.getId()));
		}
		return universityDAO.updateUniversity(university);
	}

	@Transactional(readOnly = false)
	public void deleteUniversity(int id) {
		universityDAO.deleteUniversity(id);
	}

}