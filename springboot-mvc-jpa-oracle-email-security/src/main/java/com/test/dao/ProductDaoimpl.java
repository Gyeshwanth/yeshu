package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.daoI.ProductDao;
import com.test.model.Product;
import com.test.repository.ProductRepository;

@Repository
public class ProductDaoimpl implements ProductDao {

	@Autowired
	private ProductRepository res;
	
	
	@Override
	public void save(Product product) {
		res.save(product);
		
	}

	@Override
	public void update( Product product) {
		
res.save(product);
		
	}

	@Override
	public Product findById(int id) {
		return res.findById(id);
		
	}

	@Override
	public List<Product> findAll() {
	List<Product>list =res.findAll();
		return list;
	}

	@Override

	public void deleteById(int id) {
	res.deleteById(id);
	
		
	}

	
}
