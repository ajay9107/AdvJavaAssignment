package com.airline.service;

import java.time.LocalDate;
import java.util.List;

import com.airline.entity.Flight;
import com.ariline.dao.FlightDao;

public class FlightService {

	private FlightDao flightDao;
	public FlightService() {
		flightDao = new FlightDao();
	}
    public List<Flight>searchFlight(String source,String destination,LocalDate date){
    	return flightDao.searchFlight(source, destination, date);
    }
}
