package com.solvd.airportProject.model.people.employee;

public class Pilot extends Staff{

	private String licence;

	public Pilot() {
	}

	public Pilot(String firstName, String lastName, String birthDate, String phoneNumber, String address,
			String country, Integer passport, Integer id, Float salary, String licence) {
		super(firstName, lastName, birthDate, phoneNumber, address, country, passport, id, salary);
		this.licence = licence;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}
}
