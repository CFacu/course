package com.solvd.airportProject.model.people.passenger;

import com.solvd.airportProject.model.people.User;

public abstract class Passenger extends User {
	
	protected String seatNumber;
	protected Integer ticketPrice;
	
	public Passenger() {
	}

	public abstract void calculateTicketPrice();

	public String getSeatNumber() {
		return seatNumber;
	}

	public Integer getTicketPrice() {
		return ticketPrice;
	}

}
