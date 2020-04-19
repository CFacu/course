package com.solvd.AirportProject.model.flights;

import java.util.ArrayList;
import java.util.List;

import com.solvd.AirportProject.model.Airplane;
import com.solvd.AirportProject.model.Airport;
import com.solvd.AirportProject.model.enums.FlightStatus;
import com.solvd.AirportProject.model.exceptions.FlightCapacityException;
import com.solvd.AirportProject.model.flights.passenger.Passenger;
import com.solvd.AirportProject.model.people.employee.FlightAttendant;
import com.solvd.AirportProject.model.people.employee.Pilot;

public class PassengerFlight extends Flight {

	private List<Passenger> passengers;
	private List<FlightAttendant> flightAttendants;
	
	public PassengerFlight() {
	}

	public PassengerFlight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot, List<Passenger> passengers, List<FlightAttendant> flightAtt, FlightStatus status) {
		super(flightNumber, departure, destination, airplane, pilot, status);
		this.passengers = passengers;
		this.flightAttendants = flightAtt;
	}

	public PassengerFlight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot, FlightStatus status) {
		super(flightNumber, departure, destination, airplane, pilot, status);
		this.passengers = new ArrayList<Passenger>();
		this.flightAttendants = new ArrayList<FlightAttendant>();
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void leavePassengers(List<Passenger> passengers) {
		for (Passenger passenger : passengers) {
			this.passengers.remove(passenger);
			LOGGER.info("Passenger " + passenger.getCustomer().getPassport() + " got off the plane.");

		}
	}
	
	public void setPassengers(List<Passenger> passengers) throws FlightCapacityException{
		for (Passenger passenger : passengers) {
			if (this.plane.getCapacity() == this.passengers.size()) {
				throw new FlightCapacityException("Cannot add passenger. The flight is full.");
			}
			else {
			this.passengers.add(passenger);
			//LOGGER.info("Passenger " + passenger.getCustomer().getPassport() + " got on the plane");
			}
		}
	}

	public List<FlightAttendant> getFlightAttendants() {
		return flightAttendants;
	}

	public void setFlightAttendants(List<FlightAttendant> flightAttendants) {
		this.flightAttendants = flightAttendants;
	}

	@Override
	public void fly() {
			takeOFf(departure);
			land(destination);
			leavePassengers(passengers);
		}
}
