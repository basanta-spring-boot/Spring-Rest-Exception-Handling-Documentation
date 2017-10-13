package com.spring.boot.data.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.jpa.api.dto.UserRequest;
import com.spring.boot.data.jpa.api.dto.UserResponse;
import com.spring.boot.data.jpa.api.exception.UserServiceFailureException;
import com.spring.boot.data.jpa.api.model.User;
import com.spring.boot.data.jpa.api.service.UserService;

@RestController
@RequestMapping("/Services")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request) throws UserServiceFailureException {
		List<User> users = request.getUsers();
		UserResponse response = null;
		response = userService.saveUser(users);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<UserResponse> getAllUsers() throws UserServiceFailureException {
		UserResponse response = new UserResponse();
		List<User> users = null;
		users = userService.getAllUsers();
		response.setStatus(Boolean.TRUE);
		response.setUsers(users);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserByLocation/{location}", method = RequestMethod.GET)
	public ResponseEntity<UserResponse> getAllUsers(@PathVariable("location") String location)
			throws UserServiceFailureException {
		UserResponse response = new UserResponse();
		List<User> users = null;
		users = userService.getUsersByLocation(location);
		response.setStatus(Boolean.TRUE);
		response.setUsers(users);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserResponse> getAllUsers(@PathVariable("id") int id) throws UserServiceFailureException {
		UserResponse response = new UserResponse();
		response.setStatus(Boolean.TRUE);
		response.setMessage(userService.deleteUser(id));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}