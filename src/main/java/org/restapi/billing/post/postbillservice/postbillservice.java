package org.restapi.billing.post.postbillservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.restapi.billing.post.postbillmodel.postbillmodel;

public class postbillservice {
	
	Connection con;
	
	public postbillservice() {
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
	
	public postbillmodel insertBill(postbillmodel bill) {
		String insert = "insert into bill(billID,billnumber) values(?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setLong(1, bill.getBillID());
			ps.setLong(2, bill.getBillnumber());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess");
		}
		
		return bill;
	}
	
	
	
	public ArrayList<postbillmodel> getBill() throws SQLException{
		
		ArrayList<postbillmodel> data = new ArrayList<postbillmodel>();		
		String select = "select * from billmodel";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			postbillmodel model = new postbillmodel();
			
			model.setBillID(rs.getInt("billID")); // column name
			model.setBillnumber(rs.getInt("billnumber")); // column name			
			data.add(model);
		}
			
		return data; 
	}
	
	
	public ArrayList<postbillmodel> getBilById(int id) throws SQLException{
		
		ArrayList<postbillmodel> data = new ArrayList<postbillmodel>();		
		String select = "select * from billmodel where id=?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			postbillmodel model = new postbillmodel();
			
			model.setBillID(rs.getInt("billID")); // column name
			model.setBillnumber(rs.getInt("billnumber")); // column name			
			data.add(model);
		}
			
		return data; 
	}
	

	
	
	public postbillmodel updateBill(postbillmodel bill) {
		String insert = "update person set billID=?,billnumber=? where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, bill.getId());
			ps.setInt(2, bill.getBillnumber());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess");
		}
		
		return bill;
	}
	
	
	
	
	public postbillmodel deleteBill(int id) {
		String insert = "delete from person where id";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, id);
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess");
		}
		
		return id;
	}
	
}
