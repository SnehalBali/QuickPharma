package com.quickpharma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quickpharma.daos.UserDao;
import com.quickpharma.entities.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User save(User user) {
		System.out.println(user.getPassword());
		String encPassword = passwordEncoder.encode(user.getPassword());
		System.out.println("after enc");
		user.setPassword(encPassword);
		return userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public boolean deleteById(int id) {
		if(userDao.existsById(id)) {	
			userDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public Integer userCount() {
		return userDao.userCount();
	}

	@Override
	public User authenticateUser(String email, String password) {
		User user = userDao.findByEmail(email);
		if(user!=null && passwordEncoder.matches(password, user.getPassword()))
			return user;
		return null;
	}

	@Override
	public User changePassword(String email, String password, String newPassword) {
		User user = findByEmail(email);
		
		if(user!=null && passwordEncoder.matches(password, user.getPassword())) {
			String encPass = passwordEncoder.encode(newPassword);
			user.setPassword(encPass);
			return userDao.save(user);
		}
		return null;
	}

}
