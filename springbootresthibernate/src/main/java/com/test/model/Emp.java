package com.test.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "EMPSDETAILS")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Emp implements Serializable {


	private static final long serialVersionUID = 1L;
	public static final Logger logger =LoggerFactory.getLogger(Emp.class);



	@Id
	@GeneratedValue(generator = "EMP_SEQ",strategy =GenerationType.SEQUENCE )
    @SequenceGenerator(name="EMP_SEQ",sequenceName = "EMP_SEQ",allocationSize=1)
	@Column(name="EMP_ID", unique=true, nullable=false, precision=10, scale=0)
	@Getter @Setter
	private int id;
    
	 
		@Column(name="EMP_NAME", nullable = true, length = 50)
		@Getter @Setter
		private String name;
		
		@Column(name="EMP_ROLE", nullable = true, length = 50)
		@Getter @Setter
	    private String role;
		
		@Column(name="EMP_address", nullable = true, length = 50)
		@Getter @Setter
	    private String address;
		
		@Column(name="EMP_CELL", nullable = true, length = 10)
		@Getter @Setter
	    private long cell;
		
	 public Emp(){}
	
	public Emp(String name, String role, String address, int cell) {
		super();
		this.name = name;
		this.role = role;
		this.address = address;
		this.cell = cell;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCell() {
		return cell;
	}

	public void setCell(long cell) {
		this.cell = cell;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}
}





