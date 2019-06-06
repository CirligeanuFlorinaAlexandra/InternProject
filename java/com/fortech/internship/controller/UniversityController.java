package com.fortech.internship.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fortech.internship.dao.UniversityDAO;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.model.University;
import com.fortech.internship.service.impl.FacultyService;
import com.fortech.internship.service.impl.UniversityService;

@RestController
public class UniversityController {

	//@Autowired
	//private UniversityDAO universityDAOImpl;
	@Autowired
	private UniversityService universityService;
	
	/*** Creating a new University ***/
	@RequestMapping(value = "/createUniversity", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createUniversity(@RequestBody UniversityDTO universityDTO) {
		universityService.createUniversity(universityDTO);		
	}

	
	/*** Retrieve a single University ***/
	@RequestMapping(value = "/university/{id}", produces = "application/json", method = RequestMethod.GET)
	public University getUniversityById(@PathVariable("id") int id) {
		University university = universityService.getUniversityById(id);
		return university;
	}

	/*** Retrieve all Universities ***/
	@RequestMapping(value = "/universities", produces = "application/json", method = RequestMethod.GET)
	public List<UniversityDTO> getAllUniversities() {
		List<UniversityDTO> universityList = universityService.getAllUniversities();
		return universityList;
	}

	/*** Update an University ***/
	@RequestMapping(value = "/updateUniversity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateUniversity(@RequestBody UniversityDTO universityDTO) {
		boolean updatedUniversity = universityService.updateUniversity(universityDTO);
		System.out.println(updatedUniversity);
	}

	/*** Delete an University ***/
	@RequestMapping(value = "/deleteUniversity/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUniversity(@PathVariable("id") int id) {
		universityService.deleteUniversity(id);
	}
}
