package com.org.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.dto.PassegerReq;
import com.org.dto.TicketReq;

@Service
public class TicketServiceImpl {

	private String SAVE_URL = "http://localhost:9091/ticket/api/save";
	private String GET_URL = "http://localhost:9091/ticket/api/{id}";

	public TicketReq bookTicket(PassegerReq req) {
		WebClient client = WebClient.create();
		return client.post().uri(SAVE_URL).bodyValue(req).retrieve().bodyToMono(TicketReq.class).block();

	}

	public TicketReq getTicket(Integer id) {
		WebClient webClient = WebClient.create();
		return webClient.get().uri(GET_URL, id).retrieve().bodyToMono(TicketReq.class).block();

	}

}