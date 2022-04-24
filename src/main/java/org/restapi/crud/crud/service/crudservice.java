package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.restapi.crud.crud.model.crudmodel;

public class crudservice {

	Connection con;
	
	public crudservice() {
		try { 
			String url = String.format("jdbc:mysql://localhost:3306/users");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
		} catch(Exception e) {
			System.out.println(e+"data insert unsuccess.");
		}
	}
	
	public crudmodel insertUser(crudmodel user) {
		String insert = "insert into person(name,age) values(?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setLong(2, user.getAge());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess");
		}
		
		return user;
	}
}


