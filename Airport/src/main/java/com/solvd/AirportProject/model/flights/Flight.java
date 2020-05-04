package com.solvd.airportProject.model.flights;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airportProject.model.Airline;
import com.solvd.airportProject.model.Airplane;
import com.solvd.airportProject.model.Airport;
import com.solvd.airportProject.model.enums.FlightStatus;
import com.solvd.airportProject.model.exceptions.PilotException;
import com.solvd.airportProject.model.people.employee.Pilot;

public abstract class Flight implements IFly{

	protected final static Logger LOGGER = LogManager.getLogger(Flight.class);

	protected String flightNumber;
	protected Airport departure;
	protected Airport destination;
	protected Airline airline;
	protected Airplane plane;
	protected Pilot pilot;
	protected FlightStatus status;

	public Flight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot, FlightStatus status) {
		this.flightNumber = flightNumber;
		this.departure = departure;
		this.destination = destination;
		this.plane = airplane;
		this.pilot = pilot;
		this.status = status;
	}

	public Flight() {
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public Airplane getPlane() {
		return plane;
	}

	public void setPlane(Airplane plane) {
		this.plane = plane;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	public void setPilot(Pilot pilot) throws PilotException {
		if (this.airline.getStaff().contains(pilot)){
			 this.pilot = pilot;
			 LOGGER.info("Pilot added");
		}
		 else
			 throw new PilotException("The pilot does not work with this flight's airline.");
	}

	@Override
	public void land(Airport b) {
		LOGGER.info("Landing at airport "+ b.getName());
	}

	@Override
	public void takeOFf(Airport a) {
		LOGGER.info("Talking off from airport "+ a.getName());
	}

}
