package com.raf.ticket_service.repository;

import com.raf.ticket_service.domain.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
