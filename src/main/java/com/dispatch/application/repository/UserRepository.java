package com.dispatch.application.repository;

import java.util.Optional;

import com.dispatch.application.model.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dispatch.application.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
	@Query("FROM Users where username=?1 and password=?2")
	Users validLogin(LoginRequest loginRequest);
	@Query("FROM Users where username=?1")
	Users getPassword(String username);
	@Query("FROM Users where userPersonalDetails.email=?1")
	Users findByEmail(String email);
}
