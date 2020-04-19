package com.solvd.AirportProject.model.flights.passenger;

import com.solvd.AirportProject.model.people.Customer;

public class TouristClassPassenger extends Passenger {

	private String travelCompany;
	private Float tax;

	public TouristClassPassenger() {
	}

	public TouristClassPassenger(Customer customer, String seatNumber, Float ticketPrice) {
		super(customer, seatNumber, ticketPrice);
	}

	@Override
	public void calculateTicketPrice() {
		Float calc = this.ticketPrice * (1 + tax);
		this.setTicketPrice(calc);
	}

	public String getTravelCompany() {
		return travelCompany;
	}

	public void setTravelCompany(String travelCompany) {
		this.travelCompany = travelCompany;
	}
}
