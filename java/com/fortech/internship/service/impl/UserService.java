package com.fortech.internship.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dao.FacultyDAO;
import com.fortech.internship.dao.UserDAO;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.dto.FacultyDTO;
import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.User;

@Service

public class UserService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private FacultyDAO facultyDAO;

	@Transactional
	public void createUser(UserDTO userDTO) {
		User user = new User();
		user.setApproved(userDTO.isApproved());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setAccessLevel(userDTO.getAccessLevel());
		AddressDTO addressDTO = userDTO.getAddressDTO();
		if (addressDTO != null) {
			user.setAddress(addressDAO.getAddressById(addressDTO.getId()));
		}
		FacultyDTO facultyDTO = userDTO.getFacultyDTO();
		if (facultyDTO != null) {
			user.setFaculty(facultyDAO.getFacultyById(facultyDTO.getId()));
		}
		userDAO.createUser(user);
	}

	@Transactional
	public User getUserById(int id) {
		// User user = userDAO.getUserById(id);
		// return user;
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		UserDTO userDTO = new UserDTO(user);
		return user;
	}

	@Transactional
	public List<UserDTO> getAllUsers() {

		List<User> users = userDAO.getAllUsers();
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User user : users) {
			usersDTO.add(new UserDTO(user));
		}
		return usersDTO;
	}

	@Transactional
	public boolean updateUser(UserDTO userDTO) {
		User user = null;
		if (userDTO.getId() != 0) {
			user = userDAO.getUserById(userDTO.getId());
		} else {
			user = (User) userDAO.getUserByEmail(userDTO.getEmail());
		}

		if (user != null) {

			user.setEmail(userDTO.getEmail());
			user.setAccessLevel(userDTO.getAccessLevel());
			user.setApproved(userDTO.isApproved());
			user.setName(userDTO.getName());

		}
		return userDAO.updateUser(user);
	}

	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}