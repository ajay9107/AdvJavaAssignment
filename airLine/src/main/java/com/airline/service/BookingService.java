package com.airline.service;

import com.ariline.dao.BookingDao;

public class BookingService {
    
	private BookingDao bookingDao;
	public BookingService() {
		bookingDao=new BookingDao();
	}
 public boolean bookflight(int userId, int flightId) {
	   return bookingDao.save(userId, flightId);
	

}
public boolean cancelFlight(int bId)
	{
		return bookingDao.cancelFlight(bId);
	}
}
