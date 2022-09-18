package com.quickpharma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickpharma.Service.ProductService;
import com.quickpharma.dao.ProductTypeDao;
import com.quickpharma.dtos.ProductDTO;
import com.quickpharma.dtos.ProductInDTO;
import com.quickpharma.entities.Product;
import com.quickpharma.entities.ProductType;
import com.quickpharma.models.Response;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	private ProductTypeDao typeDao;
	
	@PostMapping("")
	public ResponseEntity<?> save(ProductInDTO productInDTO){
		System.out.println(productInDTO);
		Product product = ProductInDTO.toEntity(productInDTO);
		Optional<ProductType> type = typeDao.findById(productInDTO.getProductTypeId());
		if(type!=null) {
			product.setProductType(type.orElse(null));
			product=productService.save(product, productInDTO.getThumbnail());
			return Response.success(product);	
		}
		return Response.error(null);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		try {
			productService.deleteById(id);
			return Response.success(true);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findProductById(@PathVariable("id") int id){
		try {
			Product product = productService.findProductById(id);
			if(product!=null) {
				ProductDTO result = ProductDTO.fromEntity(product);
				return Response.success(result);
			}
			return Response.error(null);
		}catch(RuntimeException e) {
			return Response.error(null);
		}
	}
	
	
	@GetMapping("")
	public ResponseEntity<?> findProductTypeAll(){
		List<Product> list=productService.findAllProduct();
		if(list != null) {
			List<ProductDTO> result = new ArrayList<>();
			for(Product product : list)
				result.add(ProductDTO.fromEntity(product));
			return Response.success(result);
		}
		return Response.error(null);
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity<?> findProductByProductTypeId(@PathVariable("id") int id){
		System.out.println(id);
		List<Product> list = productService.findProductByProductTypeId(id);
		if(list != null) {
			List<ProductDTO> result = new ArrayList<>();
			for(Product product : list)
				result.add(ProductDTO.fromEntity(product));
			return Response.success(result);
		}
		return Response.error(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id,ProductInDTO productInDTO){
		try {
			productInDTO.setProductId(id);
			Product product = ProductInDTO.toEntity(productInDTO);
			Product newProd = productService.update(product, productInDTO.getThumbnail());
			return Response.success(newProd);	
		}catch(RuntimeException e){
			e.printStackTrace();
			return Response.error(null);
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findProductByName(@PathVariable("name") String name){
		List<Product> list = productService.findByProductName(name);
		if(list != null) {
			List<ProductDTO> result = new ArrayList<>();
			for(Product product : list)
				result.add(ProductDTO.fromEntity(product));
			return Response.success(result);
		}
		return Response.error(null);
	}
	
	@GetMapping("/productcount")
	public ResponseEntity<?> productCount(){
		Integer count = productService.productCount();
		return Response.success(count);
	}
	
}
