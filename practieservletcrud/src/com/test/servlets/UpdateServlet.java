package com.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Emp;
import com.test.EmpDao.EmpDao;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	
	PrintWriter out = response.getWriter();
	
	String sid =request.getParameter("id");
	int id = Integer.parseInt(sid);
	String name= request.getParameter("name");
	String password = request.getParameter("pwd");
	String email = request.getParameter("email");
    String country = request.getParameter("country");
	
     
     Emp e = new Emp();
     
     e.setId(id);
     e.setName(name);
     e.setPassword(password);
     e.setEmail(email);
     e.setCountry(country);
     
	int status = EmpDao.update(e);
	
	if(status>0)
	{
		response.sendRedirect("ViewServlet");
	}
	else {
		
		out.println("sorry! unable to update record");
	}
	out.close();
	}
}
