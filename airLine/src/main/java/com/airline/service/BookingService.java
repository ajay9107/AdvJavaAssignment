package com.airline.service;

import java.util.List;

import com.airline.entity.Booking;
import com.ariline.dao.BookingDao;

public class BookingService {
    
	private BookingDao bookingDao;
	public BookingService() {
		bookingDao=new BookingDao();
	}
 public boolean bookflight(int userId, int flightId) {
	   return bookingDao.save(userId, flightId);
	

}
 public List<Booking> findBooking(int uId)
	{
		return bookingDao.findBooking(uId);
	}
public boolean cancelFlight(int bId)
	{
		return bookingDao.cancelFlight(bId);
	}

}
