package com.solvd.airportProject.model.people.passenger;

@FunctionalInterface
public interface IBook<T, Flight> {

	public void book(T t, Flight f);
}
