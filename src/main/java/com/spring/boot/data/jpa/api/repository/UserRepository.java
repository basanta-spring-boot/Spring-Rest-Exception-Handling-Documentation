package com.spring.boot.data.jpa.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.data.jpa.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)"
	 * )
	 */
	List<User> findByAddress(String address);

}
