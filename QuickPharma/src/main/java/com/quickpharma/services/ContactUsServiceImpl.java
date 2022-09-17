package com.quickpharma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quickpharma.DAOs.ContactUsDao;
import com.quickpharma.entities.ContactUs;

@Transactional
@Service
public class ContactUsServiceImpl implements ContactUsService {
	
	@Autowired
	private ContactUsDao contactusdao;
	
	@Override
	public ContactUs save(ContactUs contactus) {
		
		return contactusdao.save(contactus);
	}
	
	@Override
	public List<ContactUs> findAll() {
		
		return contactusdao.findAll();
	}
	
	@Override
	public boolean deleteById(int id) {
		
		if(contactusdao.existsById(id)) {
			contactusdao.deleteById(id);
			return true;
		}
		
		return false;
	}

}
