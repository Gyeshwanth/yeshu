package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

Product findById(int id);
	
}
