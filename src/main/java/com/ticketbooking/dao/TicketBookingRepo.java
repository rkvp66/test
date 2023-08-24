package com.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;


import com.ticketbooking.model.Ticket;

public interface TicketBookingRepo extends CrudRepository<Ticket, Integer>{

}
