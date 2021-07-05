package com.raf.ticket_service.service.implementation;

import com.raf.ticket_service.domain.Ticket;
import com.raf.ticket_service.dto.FlightDto;
import com.raf.ticket_service.dto.TicketCreateDto;
import com.raf.ticket_service.dto.UserDto;
import com.raf.ticket_service.mapper.FlightMapper;
import com.raf.ticket_service.mapper.UserMapper;
import com.raf.ticket_service.repository.TicketRepository;
import com.raf.ticket_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private RestTemplate userServiceApiClient;
    private RestTemplate flightServiceApiClient;
    private FlightMapper flightMapper;
    private UserMapper userMapper;

    public TicketServiceImpl(
            TicketRepository ticketRepository,
           /* @Qualifier("userServiceApiClient")*/ RestTemplate userServiceApiClient,
           /* @Qualifier("flightService")*/ RestTemplate flightServiceApiClient,
            FlightMapper flightMapper,
            UserMapper userMapper) {

        this.ticketRepository = ticketRepository;
        this.userServiceApiClient = userServiceApiClient;
        this.flightServiceApiClient = flightServiceApiClient;
        this.flightMapper = flightMapper;
        this.userMapper = userMapper;
    }

    @Override
    public void createOrder(TicketCreateDto ticketCreateDto) {
        ResponseEntity<FlightDto> flightDto = flightServiceApiClient.exchange("/flight/" + ticketCreateDto.getFlightId(), HttpMethod.GET,
                null, FlightDto.class);
        ResponseEntity<UserDto> userDto = userServiceApiClient.exchange("/user/" + ticketCreateDto.getUserId(), HttpMethod.GET,
                null, UserDto.class);
        //get flight price
        BigDecimal price = flightDto.getBody().getPrice();
        price = price.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(userDto.getBody().getDiscount()));

        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setUser(userMapper.userDtoToUser(userDto.getBody()));
        ticket.setFlight(flightMapper.flightDtoToFlight(flightDto.getBody()));
        ticketRepository.save(ticket);
    }

}
