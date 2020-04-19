package com.solvd.AirportProject.model.people.employee;

import com.solvd.AirportProject.model.people.User;

public abstract class Staff extends User{

	private Integer id;
	private Float salary;
	
	public Staff() {
	}
	
	public Staff(String firstName, String lastName, String birthDate, String phoneNumber, String address,
			String country, Integer passport, Integer id, Float salary) {
		super(firstName, lastName, birthDate, phoneNumber, address, country, passport);
		this.id = id;
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
