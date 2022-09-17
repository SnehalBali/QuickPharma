package com.quickpharma.DTOs;

import org.springframework.beans.BeanUtils;

import com.quickpharma.entities.ContactUs;

public class ContactUsDto {
	
	private int id;
	private String name;
	private String email;
	private String subject;
	private String message;
	
	public ContactUsDto() {
		
	}

	public ContactUsDto(int id, String name, String email, String subject, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactUsDto [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}
	
	public static ContactUsDto fromEntity(ContactUs contactus) {
		
		ContactUsDto contactusdto = new ContactUsDto();
		BeanUtils.copyProperties(contactus, contactusdto);
		
		return contactusdto;
	}
	
	public static ContactUs toEntity(ContactUsDto contactusdto) {
		
		ContactUs contactus = new ContactUs();
		BeanUtils.copyProperties(contactusdto, contactus);
		
		return contactus;
	}

}
