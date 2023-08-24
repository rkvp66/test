package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dao.TicketBookingRepo;
import com.ticketbooking.model.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	TicketBookingRepo ticketBookingRepo;
	
	public void bookTicket(Ticket ticket) {
		ticketBookingRepo.save(ticket);
		
	}

	public Ticket getTicket(Integer ticketId) {
		return ticketBookingRepo.findById(ticketId).orElse(new Ticket());
		
	}

	public Ticket updateTicket(Integer ticketId, String email) {
		// TODO Auto-generated method stub
		Ticket currentTicket =  ticketBookingRepo.findById(ticketId).orElse(new Ticket());
		currentTicket.setId(ticketId);
		currentTicket.setEmail(email);
		return ticketBookingRepo.save(currentTicket);
	}

	public Ticket deleteTicket(Integer ticketId) {
		Ticket currentTicket = getTicket(ticketId);
		ticketBookingRepo.deleteById(ticketId);
		return currentTicket;
	}
	

	public Ticket findAllById(Integer ticketId) {
		Ticket currentTicket = getTicket(ticketId);
		ticketBookingRepo.findAll();
		ticketBookingRepo.findById(ticketId);
		ticketBookingRepo.deleteById(ticketId);
		return currentTicket;
	}
	

	public Iterable<Ticket> bookMultipleTickets(Iterable<Ticket> tickets) {
		return ticketBookingRepo.saveAll(tickets);
	}

	public Iterable<Ticket> getAllTickets() {
		return ticketBookingRepo.findAll();
	}

	public Iterable<Ticket> getAllTickets(Iterable<Integer> ticketIds) {
		return ticketBookingRepo.findAllById(ticketIds);
		
	}

}
