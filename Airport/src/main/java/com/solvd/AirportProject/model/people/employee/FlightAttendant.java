package com.solvd.AirportProject.model.people.employee;

public class FlightAttendant extends Staff{

	public FlightAttendant() {
	}

	public FlightAttendant(String firstName, String lastName, String birthDate, String phoneNumber, String address,
			String country, Integer passport, Integer id, Float salary) {
		super(firstName, lastName, birthDate, phoneNumber, address, country, passport, id, salary);
	}

}
