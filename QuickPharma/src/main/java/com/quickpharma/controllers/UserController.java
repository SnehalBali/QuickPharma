package com.quickpharma.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickpharma.dtos.UserDTO;
import com.quickpharma.entities.User;
import com.quickpharma.services.UserService;
import com.quickpharma.models.ChangePassword;
import com.quickpharma.models.Credentials;
import com.quickpharma.models.Response;

@CrossOrigin
@RestController
@RequestMapping("")
public class UserController {

	@Autowired
	private UserService userService;
	
	 
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO userdto){ //added requestbody due to null values from postman
		System.out.println(userdto + userdto.getFirstName());
		User user = UserDTO.toEntity(userdto);
		System.out.println("I am above if");
		if(user!=null) {
			System.out.println("inside if");
			User savedUser = userService.save(user);
			
			userdto = UserDTO.fromEntity(savedUser);
			return Response.success(savedUser);
		}
		System.out.println("i am here");
		return Response.error(null);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findAll(){
		try {
			List<User> list = userService.findAll();
			List<UserDTO> result = new ArrayList<>();
			if(list!=null) {
				for (User user : list) 
					result.add(UserDTO.fromEntity(user));
				return Response.success(result);
			}else {
				return Response.error(null);
			}	
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}
	
	@DeleteMapping("/user/{id}") 
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
		try {
			userService.deleteById(id);
			return Response.success(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<?> findUser(@PathVariable("email") String email){
		try {
			User user=userService.findByEmail(email);
			if(user!=null) {
				UserDTO userDto = UserDTO.fromEntity(user);
				return Response.success(userDto);
			}
			return Response.error(null);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}
	
	@GetMapping("/usercount")
	public ResponseEntity<?> countUser(){
		Integer count = userService.userCount();
		return Response.success(count);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(Credentials cred){
		try {
			User user = userService.authenticateUser(cred.getEmail(), cred.getPassword());
			if(user!=null) {
				UserDTO userDto = UserDTO.fromEntity(user);
				return Response.success(userDto);
			}
			return Response.error(null);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return Response.error(null);
		}
	}
	
	@PostMapping("/reset-password/{email}")
	public ResponseEntity<?> changePassword(@PathVariable("email") String email, ChangePassword password){
		User user = userService.changePassword(email, password.getPassword(), password.getNewPassword());
		if(user!=null)
			return Response.success(user);
		return Response.error(null);
	}
	
	
	
	
}
