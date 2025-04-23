package com.ariline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.airline.entity.User;
import com.airline.util.jdbcUtils;
import com.flights.utility.AutoConnect;

public class UserDao {

	private String query;
	public boolean save(User user) {
		boolean status = false;
		query="insert into user(user_name,user_email,password) values(?,?,?);";
		try(
				Connection con =jdbcUtils.getDbConnection();
				PreparedStatement pstm=con.prepareStatement(query);
				){
			pstm.setString(1,user.getName());
			pstm.setString(2,user.getEmail());
			pstm.setString(3,user.getPassword());
			
			int count = pstm.executeUpdate();
			if(count > 0) {
				System.out.println(count+"row inserted !!");
				status = true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return status;	
	}
	public List<User>findAll(){
		List<User> users= new ArrayList<User>();
		query= "select * from user;";
		try(
				Connection con =jdbcUtils.getDbConnection();
			Statement stm = con.createStatement()
				){
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
	public User serachUserByEmailAndPassword(String email,String password) {
		User foundUser=null;
		query= "select * from user where user_email=? and password=?";
			try 
               (
				Connection con =jdbcUtils.getDbConnection();
				PreparedStatement pstm=con.prepareStatement(query);
){				
	pstm.setString(1, email);
	pstm.setString(2, password);
	ResultSet rs = pstm.executeQuery();
	while(rs.next()) {
		foundUser= new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return foundUser;
	}
	public Collection<User> viewAll()
	{
		query="select * from user;";
		Collection<User> users=new ArrayList<User>();
		try(Connection con=AutoConnect.autoConnect();
			Statement stmt=con.createStatement()
			)
		{
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			     users.add(user);
			}
		
	}
		catch(Exception e)
		{
			
		}
		return users;
	
}
	public User searchByMail(String email)
	{
		User user=null;
		query="select * from user where user_email=?";
		
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			)
		{
			pstmt.setString(1, email);
			ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		     user=new User(rs.getInt(1),rs.getString(1),rs.getString(2),rs.getString(3));
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	public User searchById(int id)
	{
		User user=null;
		query="select * from user where user_id=?";
		
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			)
		{
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		     user=new User(rs.getInt(1),rs.getString(1),rs.getString(2),rs.getString(3));
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}