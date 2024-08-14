package com.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
