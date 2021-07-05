package com.raf.ticket_service.service;

import com.raf.ticket_service.dto.TicketCreateDto;

public interface TicketService {
    void createOrder(TicketCreateDto ticketCreateDto);
}
