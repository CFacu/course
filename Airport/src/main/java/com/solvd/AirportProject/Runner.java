package com.solvd.airportProject;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airportProject.model.Airline;
import com.solvd.airportProject.model.Airplane;
import com.solvd.airportProject.model.Airport;
import com.solvd.airportProject.model.enums.AirportCode;
import com.solvd.airportProject.model.enums.FlightStatus;
import com.solvd.airportProject.model.exceptions.AirlineException;
import com.solvd.airportProject.model.exceptions.FlightCapacityException;
import com.solvd.airportProject.model.exceptions.FlightException;
import com.solvd.airportProject.model.exceptions.PilotException;
import com.solvd.airportProject.model.flights.Flight;
import com.solvd.airportProject.model.flights.PassengerFlight;
import com.solvd.airportProject.model.people.employee.Pilot;
import com.solvd.airportProject.model.people.passenger.BusinessClassPassenger;
import com.solvd.airportProject.model.people.passenger.FirstClassPassenger;
import com.solvd.airportProject.model.people.passenger.IBook;
import com.solvd.airportProject.model.people.passenger.Passenger;
import com.solvd.airportProject.model.people.passenger.TouristClassPassenger;

public class Runner {
	
	private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) throws PilotException {

		Airport airportA = new Airport(AirportCode.AEP);
		Airport airportM = new Airport(AirportCode.MHP);
		
		Airline airlineA = new Airline("A");
		Airline airlineB = new Airline("B");
		Airline airlineC = new Airline("C");
		
		Airplane airplane =  new Airplane();
		airplane.setCapacity(1);
		
		try {
			airportA.addAirline(airlineA);
		} catch (AirlineException e) {
			LOGGER.error(e);
		}
		try {
			airportA.addAirline(airlineB);
		} catch (AirlineException e) {
			LOGGER.error(e);
		}
		try {
			airportA.addAirline(airlineC);
		} catch (AirlineException e) {		
			LOGGER.error(e);
		}
		try {
			airportA.addAirline(airlineA);
		} catch (AirlineException e) {		
			LOGGER.error(e);
		}

		Pilot pilot = new Pilot();
		PassengerFlight flight = new PassengerFlight("123", airportA, airportM, airplane, pilot, FlightStatus.ACTIVE);
		flight.setAirline(airlineA);
		try {
			airlineA.addFlight(flight);
		} catch (FlightException e) {
			LOGGER.error(e);
		}

		try {
			airlineA.addFlight(flight);
		} catch (FlightException e) {
			LOGGER.error(e);
		}
		
		//airlineA.addStaff(pilot);
		
		try {
			flight.setPilot(pilot);
		} catch (PilotException pe) {
			LOGGER.error(pe);
		}
		
		Passenger passengerBC = new BusinessClassPassenger();
		Passenger passengerTC = new TouristClassPassenger();
		FirstClassPassenger passengerFC = new FirstClassPassenger();
		passengerFC.calculateTicketPrice();
		passengerFC.setPassport(98745633);
		passengerBC.setPassport(12334567);
	
		flight.setStatus(FlightStatus.CANCELLED);
		LOGGER.warn(flight.getStatus().toString() + " number " + flight.getFlightNumber());
		
		IBook<FirstClassPassenger, PassengerFlight> firstClassBook = (p, f) -> {f.addPassenger(passengerFC); p.setSeatNumber("first seats");};
		firstClassBook.book(passengerFC, flight);
		
		IBook<Pilot, Flight> pilotBook = (p,f) -> {try {
														f.setPilot(p);
													} catch (PilotException e) {
														LOGGER.error(e);;
													} f.setStatus(FlightStatus.OPEN);};
		pilotBook.book(pilot, flight);
/**/
	}
}
