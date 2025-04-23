package com.ariline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Booking;
import com.airline.util.jdbcUtils;
import com.flights.utility.AutoConnect;

public class BookingDao {

	private String query;
	public boolean  save(int userId,int flightId) {
		boolean status = false;
		query="insert into booking(user_id,flight_id)values(?,?)";
		try (
				Connection con = jdbcUtils.getDbConnection();
				PreparedStatement pstm = con.prepareStatement(query);
				
				)
		{
			pstm.setInt(1, userId);
			pstm.setInt(2, flightId);
			int count = pstm.executeUpdate();
			if(count>0) {
				System.out.println(count + "Row inserted !!");
				status = true;
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}
	public List<Booking> findBooking(int uId)
	{
		List<Booking> bookings=new ArrayList<>();
		{ query="select * from booking where  user_id=?";
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query)){
			pstmt.setInt(1, uId);
			 ResultSet rs= pstmt.executeQuery();
			 while(rs.next())
			 {
				bookings.add( new Booking(rs.getInt(1),rs.getInt(2),
						 rs.getInt(3),(rs.getDate(4)).toLocalDate()));
			 }
			 
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

}
		return bookings;
}
	public boolean cancelFlight(int bId)
	{
		boolean status=false;
		{ query="delete from booking where id=?";
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query)){
			pstmt.setInt(1, bId);
			int updates=pstmt.executeUpdate();
			if(updates>0)
			{
				status=true;
			}
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
		return status;
	}
}