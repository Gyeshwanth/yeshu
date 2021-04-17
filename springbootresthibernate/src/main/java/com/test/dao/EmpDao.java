package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.model.Emp;

public interface EmpDao {

	public void add(Emp emp);
	
	public void update(int id,Emp emp);
	
	public Emp findById(int id);
	
	public List<Emp> findAll();
	
	public void delete(int id);
	
	
	
	
	
}
