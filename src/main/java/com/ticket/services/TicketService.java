package com.ticket.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.dto.TicketDTO;
import com.ticket.entities.Ticket;
import com.ticket.exception.TicketException;
import com.ticket.repositories.TicketRepository;


@Service
@Transactional
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<TicketDTO> getAllResolvedTickets()
	{
		return ticketRepository.findAll().stream().map(entity-> mapper.map(entity,TicketDTO.class)).collect(Collectors.toList());
	}
	
	public TicketDTO addTicket(TicketDTO ticketDTO)
	{	
		Ticket ticket = mapper.map(ticketDTO, Ticket.class);
		return mapper.map(ticketRepository.save(ticket), TicketDTO.class);
	}
	
	public TicketDTO updateTicketDetails( Long id ,TicketDTO ticketDTO)
	{
		if (ticketRepository.existsById(id)) {
		Ticket ticket = ticketRepository.findById(id).orElseThrow();		
		mapper.map(ticketDTO, ticket);
		return mapper.map(ticketRepository.save(ticket), TicketDTO.class);
		}
		throw new TicketException("Ticket Not Found");
	}

}
