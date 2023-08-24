package com.ticketbooking.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.model.Ticket;
import com.ticketbooking.service.TicketBookingService;

@RestController
@RequestMapping("api/v1")
public class TicketBookingController {
	
	@Autowired
	TicketBookingService tbs;
	@PostMapping("bookticket")
	public void bookTicket(@RequestBody Ticket ticket) {
		tbs.bookTicket(ticket);
		
	}
	
	@GetMapping(value = "getticket/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return tbs.getTicket(ticketId);
	}

	@PutMapping(value = "updateticket/{ticketId}/{email}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId ,@PathVariable("email") String email) {
		return tbs.updateTicket(ticketId,email);
	}
	
	@DeleteMapping(value = "deleteticket/{ticketId}")
	public Ticket deleteTicket(@PathVariable("ticketId") Integer ticketId ) {
		return tbs.deleteTicket(ticketId);
	}
	
	@PostMapping("bookmultipletickets")
	public Iterable<Ticket>  bookMUltipleTickets(@RequestBody Iterable<Ticket> tickets){
		return tbs.bookMultipleTickets(tickets);
	}
	
	/*
	 * @GetMapping("getalltickets/{ticketId}") public Iterable<Ticket>
	 * getAllTickets(){ return tbs.getAllTickets(); }
	 */	
			
	@GetMapping(value = "getticketsbyid", params = "ticketids")
	public String getTicketsByIds(@PathVariable("ticketids") List<Integer> ticketIds){
		
		//Iterable<Integer> intTicketIds = ticketIds.stream().map(Integer::valueOf).collect(Collectors.toList());
		//return tbs.getAllTickets(intTicketIds);
		return ticketIds.toString();
	}

}
