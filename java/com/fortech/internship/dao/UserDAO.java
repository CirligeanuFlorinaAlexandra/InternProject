package com.fortech.internship.dao;

import java.util.List;

import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.User;

public interface UserDAO {
	public void createUser(User user);

	public User getUserById(int id);

	public User getUserByEmail(String email);

	public List<User> getAllUsers();

	public boolean updateUser(User user);

	public void deleteUser(int id);
}