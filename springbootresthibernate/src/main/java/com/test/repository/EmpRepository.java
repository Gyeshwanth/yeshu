package com.test.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Emp;

@Transactional(readOnly = true)
public interface EmpRepository extends JpaRepository<Emp, Integer>{

	@Transactional(timeout = 10)
	Emp findById(int id);
	
	@Transactional(timeout = 10)
	List<Emp> findAll();
	
	@Transactional
	<S extends Emp> S save(Emp emp);
	
	void delete(Emp emp);




}
