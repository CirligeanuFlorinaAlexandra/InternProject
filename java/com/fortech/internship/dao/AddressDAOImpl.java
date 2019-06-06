package com.fortech.internship.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.model.Address;
import com.fortech.internship.model.User;
@Component
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
	
	public Address getAddressByPostalCode(int postalCode) {
		return (Address) sessionFactory.getCurrentSession()
				.createQuery("select adr from Address adr where adr.postalCode='" + postalCode + "'").getSingleResult();
	}

	@Override
	public Address getAddressByPostalCode(String postalCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
