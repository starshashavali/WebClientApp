package com.org.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.org.dto.PassegerReq;
import com.org.dto.TicketReq;
import com.org.exception.ResourceNotFoundException;

@Service
public class TicketService {

	private Map<Integer, TicketReq> map = new HashMap<>();

	private Integer ticketId = 1;

	public TicketReq savePassenger(PassegerReq req) {
		TicketReq ticket = new TicketReq();
		BeanUtils.copyProperties(req, ticket);
		ticket.setTotalPrice(req.getPrice() * req.getNoOfPassengers());
		ticket.setStatus("Sucessfully bokked !!!...");
		ticket.setTicketId(ticketId);
		map.put(ticketId, ticket);
		ticketId++;
		return ticket;
	}

	public TicketReq getTicketById(Integer id) {
		if (map.containsKey(id)) {
			return map.get(id);
		}
		throw new ResourceNotFoundException("IdNotFound ::" + id);
	}

}
