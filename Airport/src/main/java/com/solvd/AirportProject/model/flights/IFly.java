package com.solvd.AirportProject.model.flights;

import com.solvd.AirportProject.model.Airport;

public interface IFly {
	
	public void fly();
	public void takeOFf(Airport a);
	public void land(Airport b);
}
