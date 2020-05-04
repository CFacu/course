package com.solvd.airportProject.model.flights;

import java.util.ArrayList;
import java.util.List;

import com.solvd.airportProject.model.Airplane;
import com.solvd.airportProject.model.Airport;
import com.solvd.airportProject.model.enums.FlightStatus;
import com.solvd.airportProject.model.exceptions.FlightCapacityException;
import com.solvd.airportProject.model.people.employee.FlightAttendant;
import com.solvd.airportProject.model.people.employee.Pilot;
import com.solvd.airportProject.model.people.passenger.Passenger;

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
		passengers.stream()
		.forEach(passenger -> LOGGER.info("Passenger " + passenger.getPassport() + " got off the plane"));
		this.passengers.removeAll(passengers);
	}
	
	public void setPassengers(List<Passenger> passengers) throws FlightCapacityException{	
		passengers.stream()
		.forEach(passenger -> {if (this.plane.getCapacity() == this.passengers.size())
									try {
										throw new FlightCapacityException("Cannot add passenger. The flight is full.");
									} catch (FlightCapacityException e) {
										LOGGER.error(e);
									}
								else {
									this.passengers.add(passenger);
									LOGGER.info("Passenger " + passenger.getPassport() + " got on the plane");
								};
							});
	}

	public void addPassenger(Passenger p) {
		if (this.plane.getCapacity() > this.passengers.size()) {
			this.passengers.add(p);
			LOGGER.info("Passenger " + p.getPassport() + " got on the plane");
		}
		else
			try {
				throw new FlightCapacityException("Cannot add passenger. The flight is full.");
			} catch (FlightCapacityException e) {
				LOGGER.error(e);
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
