package com.fortech.internship.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fortech.internship.dto.UserDTO;
import com.fortech.internship.model.User;
import com.fortech.internship.service.impl.UserService;

@RestController
public class UserController {

	//@Autowired
	//private UserDAO userDAOImpl;
	
	@Autowired
	private UserService userService;

	/*** Creating a new User ***/
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
	}

	/*** Retrieve a single User ***/
	@RequestMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		return user;
	}

	/*** Retrieve all Users ***/
	@RequestMapping(value = "/users", consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> userList = (List<UserDTO>) userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
	}

	/*** Update an User ***/
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void updateUser(@RequestBody UserDTO userDTO) {
		boolean updatedUser = userService.updateUser(userDTO);
		System.out.println(updatedUser);
	}

	/*** Delete a User ***/
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}

	/*
	 * @RequestMapping(value = "/listOfStrings") public String listOfStrings() {
	 * 
	 * ArrayList<String> list = new ArrayList<String>(); list.add("one");
	 * list.add("two"); list.add("three"); StringBuilder sb = new StringBuilder();
	 * for (String s : list) { sb.append(s); sb.append("\t"); }
	 * 
	 * return sb.toString(); }
	 */

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public String SayHello() {

		User user = new User();
		// user.setApproved(false);

		// CRUD operations
//		session.save(user);
//		session.update(user);
//		session.get(User, 5);
//		session.delete(user);

		return "Hello world !";
	}
}
