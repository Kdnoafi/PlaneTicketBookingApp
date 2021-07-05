package com.raf.ticket_service.mapper;

import com.raf.ticket_service.domain.Ticket;
import com.raf.ticket_service.dto.TicketDto;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    private UserMapper userMapper;
    private FlightMapper flightMapper;

    public TicketMapper(UserMapper userMapper, FlightMapper flightMapper) {
        this.userMapper = userMapper;
        this.flightMapper = flightMapper;
    }

    public TicketDto ticketToTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setUser(userMapper.userToUserDto(ticket.getUser()));
        ticketDto.setFlight(flightMapper.flightToFlightDto(ticket.getFlight()));
        ticketDto.setDate(ticket.getDate());
        return ticketDto;
    }

}
