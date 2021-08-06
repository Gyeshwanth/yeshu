package com.test.daoI;

import java.util.List;


import com.test.model.Product;

public interface ProductDao {

public void save(Product product);
	
	public void update(Product product);
	
	public Product findById(int id);
	
	public List<Product> findAll();
	
	

	void deleteById(int id);
}
