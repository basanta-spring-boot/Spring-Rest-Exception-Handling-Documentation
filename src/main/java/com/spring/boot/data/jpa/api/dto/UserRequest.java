package com.spring.boot.data.jpa.api.dto;

import java.util.List;

import com.spring.boot.data.jpa.api.model.User;

public class UserRequest {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
