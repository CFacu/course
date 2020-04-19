package com.solvd.AirportProject.model.people.passenger;

import com.solvd.AirportProject.model.people.User;

public abstract class Passenger extends User {
	
	private String seatNumber;
	protected Float ticketPrice;
	
	public Passenger() {
	}
	
	public Passenger(String seatNumber, Float ticketPrice) {
		super();
		this.seatNumber = seatNumber;
		this.ticketPrice = ticketPrice;
	}

	public abstract void calculateTicketPrice();
	
	public void setTicketPrice(Float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Float getTicketPrice() {
		return ticketPrice;
	}

}
