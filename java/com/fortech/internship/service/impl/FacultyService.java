package com.fortech.internship.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dao.FacultyDAO;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.Faculty;
import com.fortech.internship.model.User;
import com.fortech.internship.dao.UniversityDAO;

@Service

public class FacultyService {
	
	@Autowired
	private UniversityDAO universityDAO;
	

	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private FacultyDAO facultyDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	 
	@Transactional
	public void createFaculty(FacultyDTO facultyDTO) {
		Session session = sessionFactory.getCurrentSession();
		Faculty faculty = new Faculty();
		faculty.setName(facultyDTO.getName());
		session.persist(faculty);
	}
	@Transactional
	public Faculty getFacultyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty faculty = session.get(Faculty.class, id);
		FacultyDTO userDTO = new FacultyDTO(faculty);
		return faculty;
    }
	@Transactional
	public List<FacultyDTO> getAllFaculties() {
		Session session = sessionFactory.getCurrentSession();
		List<Faculty> faculties = session.createQuery("SELECT fac FROM Faculty fac").getResultList();
		List<FacultyDTO> facultiesDTO = new ArrayList<>();
		for (Faculty faculty : faculties) {
			facultiesDTO.add(new FacultyDTO(faculty));
		}
		return facultiesDTO;
    }
	@Transactional
	public boolean updateFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = null;
		if (facultyDTO.getId() != 0) {
			faculty = facultyDAO.getFacultyById(facultyDTO.getId());
		} else {
			faculty = (Faculty) facultyDAO.getFacultyByName(facultyDTO.getName());
		}

		if (faculty != null) {
			faculty.setName(facultyDTO.getName());
			AddressDTO addressDTO = facultyDTO.getAddressDto();
			UniversityDTO universityDTO = facultyDTO.getUniversityDTO();
			faculty.setAddress(addressDAO.getAddressById(addressDTO.getId()));
			faculty.setUniversity(universityDAO.getUniversityById(universityDTO.getId()));
		}
		return facultyDAO.updateFaculty(faculty);
	}
	
	@Transactional
	public void deleteFaculty(int id) {
        facultyDAO.deleteFaculty(id);
    }
}