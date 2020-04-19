package com.solvd.AirportProject.model.people.passenger;

import java.util.ArrayList;

public class FistClassPassenger extends Passenger{

	private ArrayList<String> requirements;

	@Override
	public void calculateTicketPrice() {
		Float calc;
		for (String req : requirements) {
			//calc +=  req.cost;
		}
	}

	public FistClassPassenger() {
	}


	public FistClassPassenger(String seatNumber, Float ticketPrice, ArrayList<String> requirements) {
		super(seatNumber, ticketPrice);
		this.requirements = requirements;
	}

	public ArrayList<String> getRequirements() {
		return requirements;
	}

	public void setRequirements(ArrayList<String> requirements) {
		this.requirements = requirements;
	}

}
