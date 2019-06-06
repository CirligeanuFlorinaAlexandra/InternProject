package com.fortech.internship.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dto.CityDTO;
import com.fortech.internship.model.Address;
import com.fortech.internship.model.City;
import com.fortech.internship.model.User;

@Component
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createCity(CityDTO cityDTO) {
		Session session = sessionFactory.getCurrentSession();
		City city = new City();
		city.setName(cityDTO.getName());
		city.setAddress(sessionFactory.getCurrentSession().get(Address.class, cityDTO.getAddressDTO().getId()));
		session.save(city);
		
	}

	@Override
	public City getCityById(int id) {
		//return sessionFactory.getCurrentSession().get(CityDTO.class, id);
		Session session = sessionFactory.getCurrentSession();
		return session.get(City.class, id);
	}

	@Override
	public List<City> getAllCities() {

		Session session = sessionFactory.getCurrentSession();
		List<City> cities = session.createQuery("select c from City c").getResultList();
		return cities;
	}

	@Override
	public boolean updateCity(City city) {

		return sessionFactory.getCurrentSession().save(city) != null;
	}

	@Override
	public void deleteCity(int id) {
		Session session = sessionFactory.getCurrentSession();
		City s = session.get(City.class, id);
		session.remove(s);
	}
	
	@Override
	public City getCityByName(String name) {
		return (City) sessionFactory.getCurrentSession()
				.createQuery("select c from City c where c.name='" + name + "'").getSingleResult();

	}
}
