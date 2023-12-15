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
import com.org.service.TicketService;

@RestController
@RequestMapping("/ticket/api")
public class TicketRestController {

	private TicketService tickerService;

	@Autowired
	public TicketRestController(TicketService tickerService) {
		this.tickerService = tickerService;
	}

	@PostMapping("/save")
	public ResponseEntity<TicketReq> bookTicket(@RequestBody PassegerReq req) {
		TicketReq status = tickerService.savePassenger(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTicketById(@PathVariable Integer id) {
		TicketReq ticket = tickerService.getTicketById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}

}
