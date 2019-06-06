package com.fortech.internship.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.fortech.internship.dto.UniversityDTO;
import com.fortech.internship.model.City;
import com.fortech.internship.model.University;


@Component
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UniversityDAOImpl implements UniversityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createUniversity(UniversityDTO universityDTO) {
		Session session = sessionFactory.getCurrentSession();
		University university = new University();
		university.setName(universityDTO.getName());
		university.setCity(session.get(City.class, universityDTO.getCityDTO().getId()));
		session.save(university);
	}

	@Override
	public University getUniversityById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(University.class, id);
	}

	@Override
	public List<University> getAllUniversities() {
		Session session = sessionFactory.getCurrentSession();
		List<University> universities = session.createQuery("select uni from University uni").getResultList();
		return universities;
	}

	@Override
	public boolean updateUniversity(University university) {
		return sessionFactory.getCurrentSession().save(university) != null;
	}

	@Override
	public void deleteUniversity(int id) {
		Session session = sessionFactory.getCurrentSession();
		University s = session.find(University.class, id);
		session.remove(s);
	}
	
	public University getUniversityByName(String name) {
		return (University) sessionFactory.getCurrentSession()
			.createQuery("select uni from University uni where uni.name='" + name + "'").getSingleResult();
}
}
