package com.solvd.airportProject.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airportProject.model.exceptions.FlightException;
import com.solvd.airportProject.model.flights.Flight;
import com.solvd.airportProject.model.people.employee.Staff;

public class Airline {

	static Logger LOGGER = LogManager.getLogger(Airline.class.getName());

	private String name;
	private List<Flight> flights;
	private List<Staff> staff;
	private List<Airplane> airplanes;
	
	public Airline() {
		this.staff = new ArrayList<Staff>();
		this.flights = new ArrayList<Flight>();
	}
	
	public Airline(String name, List<Flight> flights) {
		this.name = name;
		this.flights = flights;
		this.staff = new ArrayList<Staff>();
	}
	
	public Airline(String name) {
		this.name = name;
		this.flights = new ArrayList<Flight>();
		this.staff = new ArrayList<Staff>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights(){
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public void addFlight(Flight flight) throws FlightException{
		if (flights.stream().anyMatch(f -> f.equals(flight)))
			throw new FlightException("The Airline "+ this.name +" has already booked this flight.");
		else {			
			this.flights.add(flight);
			LOGGER.info("Flight "+ flight.getFlightNumber() +" added to Airline "+ this.name);
		}
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public void addStaff(Staff employee){
			this.staff.add(employee);
	}
	
	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}
}
