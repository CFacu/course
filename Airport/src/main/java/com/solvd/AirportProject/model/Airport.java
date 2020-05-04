package com.solvd.airportProject.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airportProject.model.enums.AirportCode;
import com.solvd.airportProject.model.exceptions.AirlineException;

public class Airport {
	
	protected final static Logger LOGGER = LogManager.getLogger(Airport.class);

	private AirportCode code;
	private String name;
	private String country;
	private String city;
	private List<Airline> airlines;

	public Airport(AirportCode code, List<Airline> airlines) {
		super();
		this.code = code;
		this.name = code.getName();
		this.country = code.getCountry();
		this.city = code.getCity();
		this.airlines = airlines;
	}
	
	public Airport(AirportCode code) {
		super();
		this.code = code;
		this.name = code.getName();
		this.country = code.getCountry();
		this.city = code.getCity();
		this.airlines = new ArrayList<Airline>();
	}
	
	public Airport() {
		this.airlines = new ArrayList<Airline>();
	}

	public AirportCode getCode() {
		return code;
	}

	public void setCode(AirportCode code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}
	
	public void addAirline(Airline airline) throws AirlineException {
		if(airlines.stream().anyMatch(a -> a.equals(airline))) {
			throw new AirlineException("The Airport "+ this.name +" already works with Airline " + airline.getName());
		}
		else {			
			this.airlines.add(airline);
			LOGGER.info("Airline "+ airline.getName() +" added to Airport "+ this.name);
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}

