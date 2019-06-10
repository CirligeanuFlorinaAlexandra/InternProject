package com.fortech.internship.dao;

import java.util.List;

import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.model.Faculty;


public interface FacultyDAO {
	
	public void createFaculty(Faculty faculty);
	
	public Faculty getFacultyById(int id);
	
	public Faculty getFacultyByName(String name);
	
	public List<Faculty> getAllFaculties();
	
	public boolean updateFaculty(Faculty faculty);
	
	public void deleteFaculty(int id);
	
	public List<Faculty> getFacultiesByUniversityName(String name);
	
	public List<Faculty> getFacultiesByCityName(String name);

}
