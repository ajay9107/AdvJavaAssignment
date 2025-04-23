package com.ariline.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Flight;
import com.airline.util.jdbcUtils;

public class FlightDao {

	private String query= null;
	public List<Flight>searchFlight(String source,String destination,LocalDate date){
		List<Flight> flights= new ArrayList<Flight>();
		query="select * from flight where source=? and destination=? and flight_date=?";
		try(
				Connection con = jdbcUtils.getDbConnection();
				PreparedStatement pstm = con.prepareStatement(query);
				
				) {
			pstm.setString(1, source);
			pstm.setString(2, destination);
			pstm.setDate(3, Date.valueOf(date));
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
			flights.add(new Flight(rs.getInt(1),
			rs.getString(2),
			rs.getString(3),
			rs.getString(4),
			rs.getDate(5).toLocalDate(),
			rs.getDouble(6)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
}
