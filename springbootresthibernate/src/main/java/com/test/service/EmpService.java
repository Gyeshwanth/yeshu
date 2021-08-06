package com.test.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.EmpDao;
import com.test.model.Emp;

import net.bytebuddy.asm.Advice.Return;

@Service
@Transactional
public class EmpService {
	
	@Autowired
	private EmpDao empDao;
	
	public EmpService()
	{}
	
	public void add(Emp emp)
	{
		if(emp == null)
		{
			 throw new IllegalArgumentException("The passed object cannot be null.");
		}
		empDao.add(emp);
	}
	
	public void update(int id,Emp emp)
	{
		if(id<=0 && emp==null)
		{
			throw new IllegalArgumentException("The passed object cannot be null.");	
		}
		empDao.update(id, emp);
	}
	public Emp findById(int id)
	{
		if (id <= 0) {
	
        throw new IllegalArgumentException("ID cannot be 0 or < 0");
		}
		return empDao.findById(id);
	}
	
	public List<Emp> findAll()
	{
		List<Emp>res = empDao.findAll();
		 if (res.size() > 0) {
		return res;
		}
		 else {
			 return null;
		}
	}
	
	public void delete(int id)
	{
		 if (id <= 0) {
	            throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
	        }
		 empDao.delete(id);
	}
	  

}
