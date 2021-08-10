package com.test.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.daoI.ProductDao;
import com.test.model.Product;
import com.test.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
private ProductDao dao;
	
	
	@Transactional
	public void save(Product product) {
		  dao.save(product);
	
	}
	@Transactional
	public void update(Product product) {
		dao.update(product);
		}
	@Transactional
	
	public void delete(int id) {
		dao.deleteById(id);
		
	}
	@Transactional(readOnly = true)

	public Product findById(int id) {
		Product product = dao.findById(id);
		return product;
	}
	@Transactional(readOnly = true)
	
	public List<Product> findAll() {
		List<Product>list = dao.findAll();
		return list;
	}

}
