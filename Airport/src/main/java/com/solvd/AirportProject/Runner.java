package com.solvd.AirportProject;

import java.util.ArrayList;

import org.apache.logging.log4j.*;

import com.solvd.AirportProject.model.Airline;
import com.solvd.AirportProject.model.Airplane;
import com.solvd.AirportProject.model.Airport;
import com.solvd.AirportProject.model.enums.AirportCode;
import com.solvd.AirportProject.model.enums.FlightStatus;
import com.solvd.AirportProject.model.exceptions.AirlineException;
import com.solvd.AirportProject.model.exceptions.FlightCapacityException;
import com.solvd.AirportProject.model.exceptions.FlightException;
import com.solvd.AirportProject.model.exceptions.PilotException;
import com.solvd.AirportProject.model.flights.PassengerFlight;
import com.solvd.AirportProject.model.people.employee.Pilot;
import com.solvd.AirportProject.model.people.passenger.BusinessClassPassenger;
import com.solvd.AirportProject.model.people.passenger.Passenger;
import com.solvd.AirportProject.model.people.passenger.TouristClassPassenger;

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
		passengerBC.setPassport(12334567);
		ArrayList<Passenger> pass = new ArrayList<Passenger>();
		pass.add(passengerBC);
		pass.add(passengerTC);
		try {
			flight.setPassengers(pass);
		} catch (FlightCapacityException e) {
			LOGGER.error(e);
		}
		
		flight.setStatus(FlightStatus.CANCELLED);
		LOGGER.warn(flight.getStatus().toString() + " number " + flight.getFlightNumber());
/**/
	}
}
