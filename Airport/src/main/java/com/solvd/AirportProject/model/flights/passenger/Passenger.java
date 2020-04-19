package com.solvd.AirportProject.model.flights.passenger;

import com.solvd.AirportProject.model.people.Customer;

public abstract class Passenger {
	
	private Customer customer;
	private String seatNumber;
	protected Float ticketPrice;
	
	public Passenger() {
	}
	
	public Passenger(Customer customer, String seatNumber, Float ticketPrice) {
		super();
		this.customer = customer;
		this.seatNumber = seatNumber;
		this.ticketPrice = ticketPrice;
	}

	public abstract void calculateTicketPrice();
	
	public void setTicketPrice(Float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
