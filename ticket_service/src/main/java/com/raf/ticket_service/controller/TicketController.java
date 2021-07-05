package com.raf.ticket_service.controller;

import com.raf.ticket_service.dto.TicketCreateDto;
import com.raf.ticket_service.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody @Valid TicketCreateDto ticketCreateDto) {
        ticketService.createOrder(ticketCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
