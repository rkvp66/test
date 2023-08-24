package com.ticketbooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Ticket {
	
	public Ticket() {}
	public Ticket(int id, String startFrom, String destinationTo, String email, int travelDate) {
		super();
		this.id = id;
		this.startFrom = startFrom;
		this.destinationTo = destinationTo;
		this.email = email;
		this.travelDate = travelDate;
	}

	@Id
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}
	public String getDestinationTo() {
		return destinationTo;
	}
	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//String name;
	String startFrom;
	String destinationTo;
	String email ;
	int travelDate;
	public int getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(int travelDate) {
		this.travelDate = travelDate;
	}
	

}
