package com.test;

public class Student {

	private int id;
	private String name,college;
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void show()
	{
	System.out.println("id"+id+" "+"name"+name+" "+"college"+college+" "+"address"+address);
	System.out.println(address.addr());
	}	
}
