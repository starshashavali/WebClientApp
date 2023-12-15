package com.org.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.PassegerReq;
import com.org.dto.TicketReq;
import com.org.service.Impl.TicketServiceImpl;

@RestController
@RequestMapping("/ticket/api")
public class TicketRestController {

	private TicketServiceImpl ticketServiceImp;

	@Autowired
	public TicketRestController(TicketServiceImpl ticketServiceImp) {
		this.ticketServiceImp = ticketServiceImp;
	}

	@PostMapping("/save")
	public ResponseEntity<TicketReq> bookTicket(@RequestBody PassegerReq req) {
		TicketReq ticket = ticketServiceImp.bookTicket(req);
		return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TicketReq> getTicket(@PathVariable Integer id) {
		TicketReq ticket = ticketServiceImp.getTicket(id);
		return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}

}
