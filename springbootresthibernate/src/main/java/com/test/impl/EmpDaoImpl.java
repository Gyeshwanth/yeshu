package com.test.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.EmpDao;
import com.test.model.Emp;
import com.test.repository.EmpRepository;

@Repository
public class EmpDaoImpl implements EmpDao{

	
	private static final Logger logger = LoggerFactory.getLogger(EmpDaoImpl.class);
	
	@Autowired
	private EmpRepository emprepository;
	
	 public EmpDaoImpl() {
		
	}
	
	
	@Override
	public void add(Emp emp) {
		try {
		emprepository.save(emp);
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}

	@Override
	public void update(int id, Emp emp) {
		try {
			emp.setId(id);
			emprepository.save(emp);
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}

	@Override
	public Emp findById(int id) {
		try {
			return emprepository.findById(id);
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	@Override
	public List<Emp> findAll() {
		try {
			List<Emp>list =  emprepository.findAll();
		
		     return list;
		
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	@Override
	public void delete(int id) {
		try {
		 Emp emp = new Emp();
		 emp.setId(id);
		 emprepository.delete(emp);
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}

}
