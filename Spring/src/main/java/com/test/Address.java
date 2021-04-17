package com.test;

public class Address
{
private String city;
private String dist;
private String state;
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDist() {
	return dist;
}
public void setDist(String dist) {
	this.dist = dist;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String addr()
{
	return ("city:"+city+" "+"dist:"+dist+" "+"state:"+state);
	
}

}
