package com.solvd.airportProject.model.enums;

public enum AirportCode {
	AEP("Jorge Newbery Airpark", "Argentina", "Buenos Aires"),
	MHP("Minks International Airport", "Belarus", "Minsk"),
	ATL("Hartsfield-Jackson Atlanta International","USA", "Atlanta"),
	PEK("Beijing Capital International Airport", "China", "Beijing"),
	ORD("Chicago O'Hare Airport", "USA", "Chicago"),
	LHR("London Heathrow","UK", "London"),
	HND("Haneda Airport", "Japan", "Tokyo"),
	LAX("Los Angeles International", "USA", "Los Angeles"),
	CDG("Paris-Charles de Gaulle Airport", "France", "Paris"),
	FRA("Frankfurt Airport", "Germany", "Frankfurt"),
	MAD("Adolfo Suárez Madrid-Barajas", "Spain", "Madrid");
	
	private final String name;
	private final String country;
	private final String city;
	
	private AirportCode(String name, String country, String city) {
		this.name = name;
		this.country = country;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getCity() {
		return city;
	}
}
