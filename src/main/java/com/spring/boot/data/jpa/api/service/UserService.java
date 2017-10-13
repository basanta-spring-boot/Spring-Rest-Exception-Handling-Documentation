package com.spring.boot.data.jpa.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.data.jpa.api.dto.UserResponse;
import com.spring.boot.data.jpa.api.exception.UserServiceFailureException;
import com.spring.boot.data.jpa.api.model.User;
import com.spring.boot.data.jpa.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserResponse saveUser(List<User> users) throws UserServiceFailureException {
		UserResponse response = new UserResponse();
		if (!users.isEmpty()) {
			userRepository.save(users);
			response.setStatus(Boolean.TRUE);
			response.setMessage(users.size() + " Record Inserted !!");
		} else {
			throw new UserServiceFailureException("Input Request should not be Empty");
		}
		return response;
	}

	public List<User> getAllUsers() throws UserServiceFailureException {
		List<User> users = userRepository.findAll();
		if (users != null && !users.isEmpty()) {
			return users;
		} else {
			throw new UserServiceFailureException("User Not Found in DataBase");
		}
	}

	public List<User> getUsersByLocation(String location) throws UserServiceFailureException {
		List<User> users = userRepository.findByAddress(location);
		if (users != null && !users.isEmpty()) {
			return users;
		} else {
			throw new UserServiceFailureException("User Not Found in for location :" + location);
		}
	}

	public String deleteUser(int id) throws UserServiceFailureException {
		boolean isUserExist = getAllUsers().stream().anyMatch(user -> user.getId() == id);
		if (isUserExist) {
			userRepository.delete(id);
			return "record deleted";
		} else {
			throw new UserServiceFailureException("User not exist with id " + id);
		}

	}
}
