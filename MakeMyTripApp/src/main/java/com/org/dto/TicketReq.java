package com.org.dto;

import lombok.Data;

@Data
public class TicketReq {

	private Integer ticketId;

	private String name;

	private String email;

	private Double price;

	private Integer noOfPassengers;

	private Double totalPrice;

	private String status;
}