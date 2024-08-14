package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.dto.TicketDTO;
import com.ticket.services.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public ResponseEntity<?> getAllTickets()
	{
		return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAllResolvedTickets());
	}
	
	@PostMapping
	public ResponseEntity<?> addTicket(@RequestBody TicketDTO ticket ){
		return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.addTicket(ticket));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTicket(@PathVariable Long id,@RequestBody TicketDTO updatedTicket)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ticketService.updateTicketDetails(id, updatedTicket));
	}

}
