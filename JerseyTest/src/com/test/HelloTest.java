package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloTest {
	
	@GET
	@Path("/text")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHellTextPlain()
	{
		return"welcome to rest api first example";
	}
	
	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHtml()
	{
		return"<html>  "+"<title> "+"Hello Jersey"+"</title>"+"<body>"+"<h2>"+"Tested for Html service"+"</h2>"+"<body>"+"</html>";
	}

}
