package com.ticket.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import com.ticket.entities.Category;
import com.ticket.entities.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class TicketDTO {
	@NotNull
	@Column(name = "phone_no" ,unique=true)
	private long phoneNumber;
	@NotNull
	@Column(name = "issue_details")
	private String issueDetails;
	@Null(message = "Resolution is Nullable")
	@Column(name = "resolution_details")
	private String resolutionDetails;
	@NotNull
	private Category category;
	@NotNull
	private Status status;
	
}
