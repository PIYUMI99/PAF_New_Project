package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.crud.crud.model.crudmodel;

public class crudservice {
	
	Connection con;

	
	public crudservice(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/users");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}

	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into person(name,nic,address,telNo,accNo) values(?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getNic());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getTelNo());
			ps.setInt(5, user.getAccNo());
			
			ps.execute();
			
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	
	public ArrayList<crudmodel> getUser() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from person";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
													// column name
			model.setName(rs.getString("name"));
			model.setNic(rs.getString("nic"));
			model.setAddress(rs.getString("address"));
			model.setTelNo(rs.getInt("telNo"));
			model.setAccNo(rs.getInt("accNo"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<crudmodel> getUserById(int id) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from person where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setName(rs.getString("name")); // column name
			model.setNic(rs.getString("nic"));
			model.setAddress(rs.getString("address"));
			model.setTelNo(rs.getInt("telNo"));
			model.setAccNo(rs.getInt("accNo"));
			
			data.add(model);		
		}		
		return data;	
	}
	
	public crudmodel updatetUser(crudmodel user) {
		String insert = "update person set name=? , nic=? , address=? , telNo=? , accNo=?  where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getNic());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getTelNo());
			ps.setInt(5, user.getAccNo());
			ps.setInt(6, user.getId());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	

	public int deletetUser(int id) {
		String insert = "delete from person where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
		
	}
	
	


}

