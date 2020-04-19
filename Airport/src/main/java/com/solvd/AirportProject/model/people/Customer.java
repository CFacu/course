package com.solvd.AirportProject.model.people;

public class Customer extends User {

	public Customer() {
	}

	public Customer(String firstName, String lastName, String birthDate, String phoneNumber, String address,
			String country, Integer passport) {
		super(firstName, lastName, birthDate, phoneNumber, address, country, passport);
	}

}
