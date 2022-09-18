package com.quickpharma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickpharma.Service.ProductTypeService;
import com.quickpharma.dtos.ProductTypeInDTO;
import com.quickpharma.entities.ProductType;
import com.quickpharma.models.Response;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class ProductTypeController {
	@Autowired
	ProductTypeService productTypeService;
	
	@PostMapping("")
	public ResponseEntity<?> save (ProductTypeInDTO productTypeDto){
		try
		{ ProductType productType= ProductTypeInDTO.toEntity(productTypeDto);
			if(productType!=null) {
				productType =productTypeService.saveProductType(productType, productTypeDto.getTypeThumbnail());
				return Response.success(productType);
			}
			return Response.error(null);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
			
		}
	}
}
