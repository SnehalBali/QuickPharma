package com.quickpharma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickpharma.entities.ProductType;

public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
	
}
