package com.solvd.AirportProject.model.people.passenger;

public class BusinessClassPassenger extends Passenger {

	private String companyName;
	private Float discount;

	public BusinessClassPassenger() {
	}

	public BusinessClassPassenger(String seatNumber, Float ticketPrice, String company, Float discount) {
		super(seatNumber, ticketPrice);
		this.companyName = company;
		this.discount = discount;
	}

	@Override
	public void calculateTicketPrice() {
		Float calc = this.ticketPrice * (1- discount);
		this.setTicketPrice(calc);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}
}
