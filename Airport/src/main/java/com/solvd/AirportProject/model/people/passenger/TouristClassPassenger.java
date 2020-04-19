package com.solvd.AirportProject.model.people.passenger;

public class TouristClassPassenger extends Passenger {

	private String travelCompany;
	private Float tax;

	public TouristClassPassenger() {
	}

	public TouristClassPassenger(String seatNumber, Float ticketPrice) {
		super(seatNumber, ticketPrice);
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
