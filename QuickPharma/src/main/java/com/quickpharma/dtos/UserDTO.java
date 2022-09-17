package com.quickpharma.dtos;

import org.springframework.beans.BeanUtils;

import com.quickpharma.entities.User;

public class UserDTO {

	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String mobileNumber;
	
	private String role;

	public UserDTO(int userId, String firstName, String lastName, String email, String password, String mobileNumber,
			String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", role=" + role + "]";
	}
	
	public static UserDTO fromEntity(User user) {
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}
	
	public static User toEntity(UserDTO dto) {
		System.out.println(dto.getPassword());
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;
	}
}
