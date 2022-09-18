package com.quickpharma.services;

import java.util.List;

import com.quickpharma.entities.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	boolean deleteById(int id);

	User findByEmail(String email);

	Integer userCount();

	User authenticateUser(String email, String password);

	User changePassword(String email, String password, String newPassword);

	
	
	

}
