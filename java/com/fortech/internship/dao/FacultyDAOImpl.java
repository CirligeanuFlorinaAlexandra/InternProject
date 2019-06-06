package com.fortech.internship.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dto.CityDTO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.model.Faculty;
import com.fortech.internship.model.University;
import com.fortech.internship.model.User;

@Component
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class FacultyDAOImpl implements FacultyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createFaculty(Faculty faculty) {
		Session session = sessionFactory.getCurrentSession();
		session.save(faculty);
	}

	@Override
	public Faculty getFacultyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Faculty.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Faculty> getAllFaculties() {
		Session session = sessionFactory.getCurrentSession();
		List<Faculty> faculties = session.createQuery("select fac from Faculty fac").getResultList();
		return faculties;
	}

	@Override
	public boolean updateFaculty(Faculty faculty) {
		return sessionFactory.getCurrentSession().save(faculty) != null;
	}

	@Override
	public void deleteFaculty(int id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty s = session.get(Faculty.class, id);
		session.remove(s);
	}

	@Override
	public Faculty getFacultyByName(String name) {
		return (Faculty) sessionFactory.getCurrentSession()
				.createQuery("select fac from Faculty stu where fac.name='" + name + "'").getSingleResult();
	}
}
