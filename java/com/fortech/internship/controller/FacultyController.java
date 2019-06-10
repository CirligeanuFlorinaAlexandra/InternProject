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
import com.fortech.internship.service.impl.mapper.ToEntity;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	/*** Creating a new Faculty ***/
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createFaculty(@RequestBody FacultyDTO facultyDTO) {
		facultyService.createFaculty(facultyDTO);
	}

	/*** Retrieve a single Faculty ***/
	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public Faculty getFacultyById(@PathVariable("id") int id) {
		Faculty faculty = ToEntity.faculty(facultyService.getFacultyById(id));
		return faculty;
	}

	/*** Retrieve all Faculties ***/
	@RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
	public List<FacultyDTO> getAllFaculties() {
		List<FacultyDTO> facultyList = (List<FacultyDTO>) facultyService
				.getAllFaculties();
		return facultyList;
	}

	/*** Update an Faculty ***/
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateUniversity(@RequestBody FacultyDTO facultyDTO) {
		boolean updatedFaculty = facultyService.updateFaculty(facultyDTO);
		System.out.println(updatedFaculty);
	}

	/*** Delete an Faculty ***/
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteFaculty(@PathVariable("id") int id) {
		facultyService.deleteFaculty(id);
	}

	/*** Retrieve all Faculties by University name ***/

	@RequestMapping(value = "/facultiesByUniversityName/{name}", produces = "application/json", method = RequestMethod.GET)
	public List<FacultyDTO> getFacultiesByUniversityName(
			@PathVariable("name") String name) {
		return facultyService.getFacultiesByUniversityName(name);
	}

	/*** Retrieve all Faculties by City name ***/

	@RequestMapping(value = "/facultiesByCityName/{name}", produces = "application/json", method = RequestMethod.GET)
	public List<FacultyDTO> getFacultiesByCityName(
			@PathVariable("name") String name) {
		return facultyService.getFacultiesByCityName(name);
	}
}