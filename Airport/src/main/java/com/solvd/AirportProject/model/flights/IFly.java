package com.solvd.airportProject.model.flights;

import com.solvd.airportProject.model.Airport;

public interface IFly {
	
	public void fly();
	public void takeOFf(Airport a);
	public void land(Airport b);
}
