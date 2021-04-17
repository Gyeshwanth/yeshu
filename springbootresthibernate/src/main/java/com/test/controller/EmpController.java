package com.test.controller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Emp;
import com.test.service.EmpService;


@RestController
@RequestMapping(value = "/rest/emps")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	 
	 
	@Autowired
 private EmpService empservice;

    

	@RequestMapping(value = "",method = RequestMethod.POST )
	public ResponseEntity<Void> create(@RequestBody Emp emp)
	{
		try {
			empservice.add(emp);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id")int id,@RequestBody Emp emp)
	{
		try {
			empservice.update(id, emp);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
					
		}
	}
   
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Emp> getById(@PathVariable("id") int id)
	{
		try {
			Emp emp = empservice.findById(id);
			 
			if(emp !=null)
			{
				return ResponseEntity.status(HttpStatus.OK).body(emp);
			}
			else
			{
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
			}
			}
			catch (Exception e) {
				logger.error(e.getMessage(), e);
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		
		}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Emp>> getAll()
	{
		try {
			List<Emp> res=empservice.findAll();
			 return ResponseEntity.status(HttpStatus.OK).body(res);
		}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id)
	{
		try {
			empservice.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
