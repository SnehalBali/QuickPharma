package com.quickpharma.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickpharma.DTOs.ContactUsDto;
import com.quickpharma.entities.ContactUs;
import com.quickpharma.entities.Response;
import com.quickpharma.services.ContactUsService;

@CrossOrigin
@RestController
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactusservice;
	
	@PostMapping("/contactus")
	public ResponseEntity<?> saveFeedback(@RequestBody @Valid ContactUsDto contactusdto) {
		
		try {
			
			ContactUs contactus = ContactUsDto.toEntity(contactusdto);
			ContactUs feedback = contactusservice.save(contactus);
			contactusdto = ContactUsDto.fromEntity(feedback);
			
			return Response.success(contactusdto);
		
		}
		catch(RuntimeException e) {
			
			return Response.error(null);
		}
	}
	
	@GetMapping("/contactus")
	public ResponseEntity<?> getAll() {
		
		try {
			
			List<ContactUs> list = contactusservice.findAll();
			List<ContactUsDto> result = new ArrayList<>();
			for(ContactUs contactus: list)
				result.add(ContactUsDto.fromEntity(contactus));
			
			return Response.success(result);
		}
		catch(RuntimeException e) {
			
			return Response.error(null);
		}
	}
	
	@DeleteMapping("/contactus/{id}")
	public ResponseEntity<?> deletefeedback(@PathVariable("id") int id) {
		
		try {
			
			if(!contactusservice.deleteById(id))
				return Response.error(id+":Record dose not exists");
									
			return Response.success(true);
		}
		catch(RuntimeException e) {
			
			return Response.error(null);
		}
	}

}
