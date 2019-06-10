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
import com.fortech.internship.service.impl.mapper.ToDTO;
import com.fortech.internship.service.impl.mapper.ToEntity;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private FacultyDAO facultyDAO;

	@Transactional(readOnly = false)
	public void createUser(UserDTO userDTO) {
		userDAO.createUser(ToEntity.user(userDTO));
	}

	@Transactional(readOnly = true)
	public UserDTO getUserById(int id) {
		UserDTO userDTO = ToDTO.user(userDAO.getUserById(id));
		return userDTO;
	}

	@Transactional(readOnly = true)
	public List<UserDTO> getAllUsers() {

		List<User> users = userDAO.getAllUsers();
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User user : users) {
			usersDTO.add(ToDTO.user(user));
		}
		return usersDTO;
	}

	@Transactional(readOnly = false)
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

	@Transactional(readOnly = false)
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}