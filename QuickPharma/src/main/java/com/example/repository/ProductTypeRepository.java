package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {

}
