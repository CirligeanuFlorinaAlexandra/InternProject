package com.fortech.internship.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.internship.dao.FacultyDAO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.model.Faculty;
import com.fortech.internship.service.impl.CityService;
import com.fortech.internship.service.impl.FacultyService;

@RestController

public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	/*** Creating a new Faculty ***/
	@RequestMapping(value = "/createFaculty", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createFaculty(@RequestBody FacultyDTO facultyDTO) {
		facultyService.createFaculty(facultyDTO);		
	}

	/*** Retrieve a single Faculty ***/
	@RequestMapping(value = "/faculty/{id}", produces = "application/json", method = RequestMethod.GET)
	public Faculty getFacultyById(@PathVariable("id") int id) {
		Faculty faculty = facultyService.getFacultyById(id);
		return faculty;
	}

	/*** Retrieve all Faculties ***/
	@RequestMapping(value = "/faculties", produces = "application/json", method = RequestMethod.GET)
	public List<FacultyDTO> getAllFaculties() {
		List<FacultyDTO> facultyList = (List<FacultyDTO>) facultyService.getAllFaculties();
		return facultyList;
	}

	/*** Update an Faculty ***/
	@RequestMapping(value = "/updateFaculty", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateUniversity(@RequestBody FacultyDTO facultyDTO) {
		boolean updatedFaculty = facultyService.updateFaculty(facultyDTO);
		System.out.println(updatedFaculty);
	}

	/*** Delete an Faculty ***/
	@RequestMapping(value = "/deleteFaculty/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteFaculty(@PathVariable("id") int id) {
		facultyService.deleteFaculty(id);
	}
}