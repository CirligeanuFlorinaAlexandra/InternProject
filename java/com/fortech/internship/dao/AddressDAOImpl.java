package com.fortech.internship.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

import com.fortech.internship.model.Address;
import com.fortech.internship.model.User;
import com.fortech.internship.service.impl.mapper.ToEntity;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AddressDAOImpl implements AddressDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.save(address);
	}

	@Override
	public Address getAddressById(int id) {
		return sessionFactory.getCurrentSession().get(Address.class, id);
	}

	@Override
	public List<Address> getAllAddresses() {
		Session session = sessionFactory.getCurrentSession();
		List<Address> addresses = session.createQuery("select adr from Address adr").getResultList();
		return addresses;
	}

	@Override
	public boolean updateAddress(Address address) {
		return sessionFactory.getCurrentSession().save(address) != null;
	}

	@Override
	public void deleteAddress(int id) {
		Session session = sessionFactory.getCurrentSession();
		Address s = session.get(Address.class, id);
		session.remove(s);
	}
	
	public Address getAddressByPostalCode(String postalCode) {
		return (Address) sessionFactory.getCurrentSession()
				.createQuery("select adr from Address adr where adr.postalCode='" + postalCode + "'").getSingleResult();
	}

}
