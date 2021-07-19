package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Product;

@Repository
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
  public void createProduct(Product product) {
		
		hibernateTemplate.saveOrUpdate(product);
	}

	@Transactional
	public List<Product> getProducts(){
		
		List< Product>list = hibernateTemplate.loadAll(Product.class);
		return list;
	}
	@Transactional
	public void deleteProduct(int id) {
	Product p =	 hibernateTemplate.load(Product.class, id);
	    hibernateTemplate.delete(p);
	}

	@Transactional
	public Product getProductId(int id) {
		
		 Product product =hibernateTemplate.get(Product.class, id);
		return product;
	
	}




}
