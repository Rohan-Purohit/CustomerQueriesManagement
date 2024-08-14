package com.ticket.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	@Column(length = 10)
	private long phoneNumber;
	@Column(length = 200)
	private String issueDetails;
	@Column(length = 200)
	private String resolutionDetails;
	@Column(length = 20)
	private Category category;
	@Column(length = 20)
	private Status status;
	
	@CreationTimestamp
	private LocalDate creationDate;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
}
