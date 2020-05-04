package com.solvd.airportProject.model.flights;

import com.solvd.airportProject.model.Airplane;
import com.solvd.airportProject.model.Airport;
import com.solvd.airportProject.model.enums.FlightStatus;
import com.solvd.airportProject.model.people.employee.Pilot;

public class CargoFlight extends Flight{
	
	private Float cargo;

	public CargoFlight() {
		super();
	}

	public CargoFlight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot, Float cargo, FlightStatus status) {
		super(flightNumber, departure, destination, airplane, pilot, status);
		this.cargo = cargo;
	}

	@Override
	public void fly() {			
			takeOFf(departure);
			land(destination);
			dropLoad();
	}

	private void dropLoad() {
		this.cargo = (float) 0;
	}

	public Float getCargo() {
		return cargo;
	}

	public void setCargo(Float cargo) {
		this.cargo = cargo;
	}
	
}
