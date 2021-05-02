package com.test.EmpDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.Emp;

public class EmpDao {

	public static Connection getConnection()
	{
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","java");
		}
		catch (Exception e) {
			
		}
		return con;
	}
	
	public static int save(Emp e)
	{
		int status = 0;
		try {
		Connection con = EmpDao.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into emp09 values(?,?,?,?,?)");
		
		pst.setInt(1, e.getId());
		pst.setString(2, e.getName());
        pst.setString(3, e.getPassword());	
        pst.setString(4, e.getEmail());
        pst.setString(5, e.getCountry());
		
        status =pst.executeUpdate();
        
        con.close();
		}
		catch (Exception e1) {
			
		}
        return status;
	}
	public static int update(Emp e)
	{
		int status=0;
		try
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement pst = con.prepareStatement("update emp09 set name=?,password=?,email=?,country=? where id=?");
		     pst.setString(1, e.getName());
			pst.setString(2,e.getPassword());
			pst.setString(3, e.getEmail());
			pst.setString(4, e.getCountry());
			pst.setInt(5, e.getId());
			
			status = pst.executeUpdate();
			con.close();
		}
		catch (Exception e2) {
			// TODO: handle exception
		}
		
		return status;
	}
	public static int delete(int id)
	{
		int status=0;
		
		try
		{
			Connection con = EmpDao.getConnection();
			
			PreparedStatement pst = con.prepareStatement("delete from emp09 where id=?");
			
			pst.setInt(1,id);
		
			status =pst.executeUpdate();
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return id;
		
	}
	public static Emp getEmployeeById(int id)
	{
		Emp e = new Emp();
		
		try
		{
			Connection con = EmpDao.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from emp09 where id=? ");
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				
			}
			con.close();
		}catch (Exception e3) {
			
		}
		return e;
		
	}
	public static List<Emp> getAllEmployees()
	{
		List<Emp> list = new ArrayList<Emp>();
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from emp09");
		
		  ResultSet rs= pst.executeQuery();
		  while(rs.next()) {
			  Emp e = new Emp();
			  e.setId(rs.getInt(1));
			  e.setName(rs.getString(2));
		      e.setPassword(rs.getString(3));
		      e.setEmail(rs.getString(4));
		      e.setCountry(rs.getString(5));
	         
		      list.add(e);
		   
		  }
		   con.close();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
}
