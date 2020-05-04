package com.solvd.airportProject.model.people.passenger;

import java.util.ArrayList;

public class FirstClassPassenger extends Passenger{

	private ArrayList<String> requirements;

	public FirstClassPassenger() {
		requirements = new ArrayList<String>();
	}

	public FirstClassPassenger(String seatNumber, Float ticketPrice, ArrayList<String> requirement) {
		super();
		this.requirements = requirements;
		this.seatNumber = seatNumber;
		calculateTicketPrice();

	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public ArrayList<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(ArrayList<String> requirements) {
		this.requirements = requirements;
	}

	@Override
	public void calculateTicketPrice() {
		this.ticketPrice = requirements.stream().mapToInt(r-> r.length()*1000).sum();
	}	
}
