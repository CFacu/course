package com.solvd.airportProject.model.people.passenger;

public class TouristClassPassenger extends Passenger {

	private String travelCompany;
	private Integer tax;

	public TouristClassPassenger() {
	}

	public TouristClassPassenger(String seatNumber, Integer ticketPrice) {
		super();
		calculateTicketPrice();
	}

	@Override
	public void calculateTicketPrice() {
		this.ticketPrice = ticketPrice * (1 + tax);
	}

	public String getTravelCompany() {
		return travelCompany;
	}

	public void setTravelCompany(String travelCompany) {
		this.travelCompany = travelCompany;
	}
}
