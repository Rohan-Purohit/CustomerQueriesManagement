package com.ticket.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

	private String message;
	private LocalDateTime ts;

	public ApiResponse(String messg) {
		this.message = messg;
		this.ts = LocalDateTime.now();
	}
	
	
}
