package com.airline.entity;

import java.time.LocalDate;

public class Flight {

	private int id;
	private String flightNumber;
	private String source;
	private String destination;
	private LocalDate flightDate;
	private double price;
	
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}


	public Flight(String flightNumber, String source, String destination, LocalDate flightDate, double price) {

       
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.price = price;
	}
	


	public Flight(int id, String flightNumber, String source, String destination, LocalDate flightDate, double price) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.price = price;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public LocalDate getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", source=" + source + ", destination="
				+ destination + ", flightDate=" + flightDate + ", price=" + price + "]";
	}
	
    
}
