package com.solvd.Person;

public class Person {

	private String name;
	private Integer id;
	private String email;

	public Person() {
	}
	
	public Person(String name, Integer id, String email) {
		this.name = name;
		this.id = id;
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Person p =  (Person) obj;
		if (!(obj instanceof Person)) {
			return false;
		}
		if (this.hashCode() != p.hashCode()) {
			return false;
		}
		if (this.name.equals(p.getName())) {
			if (this.id.equals(p.getId())) {
				if (this.email.equals(p.getEmail())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		Integer hash = 0;
		hash =  name.hashCode() + id.hashCode() - email.hashCode();
		return hash.hashCode();
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\nID: " + this.id + "\nEmail: " + this.email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public static void main(String[] args) {

	}

}
