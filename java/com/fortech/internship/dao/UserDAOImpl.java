package com.fortech.internship.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.User;
import com.fortech.internship.service.impl.mapper.ToEntity;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);

	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("select stu from User stu")
				.getResultList();
		return users;
	}

	@Override
	public boolean updateUser(User user) {
		return sessionFactory.getCurrentSession().save(user) != null;

	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User s = session.get(User.class, id);
		session.remove(s);
	}

	@Override
	public User getUserByEmail(String email) {
		return (User) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select stu from User stu where stu.email='" + email
								+ "'").getSingleResult();

	}
}