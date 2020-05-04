package com.solvd.airportProject.model.people.passenger;

public class BusinessClassPassenger extends Passenger {

	private String companyName;
	private Integer discount;

	public BusinessClassPassenger() {
	}

	public BusinessClassPassenger(String seatNumber, Integer ticketPrice, String company, Integer discount) {
		super();
		this.companyName = company;
		this.discount = discount;
		calculateTicketPrice();
	}

	@Override
	public void calculateTicketPrice() {
		this.ticketPrice = ticketPrice * (1 - discount);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
}
