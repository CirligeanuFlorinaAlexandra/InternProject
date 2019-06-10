package com.fortech.internship.dao;
import java.util.List;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.model.University;

public interface UniversityDAO {
	
	public void createUniversity(University university);
	
	public University getUniversityById(int id);
	
	public List<University> getAllUniversities();
	
	public boolean updateUniversity(University university);
	
	public void deleteUniversity(int id);

	public University getUniversityByName(String name);

}
