package com.raf.ticket_service.dto;

import com.raf.ticket_service.domain.Flight;
import com.raf.ticket_service.domain.User;

import java.math.BigDecimal;
import java.util.Date;

public class TicketDto {

    private String id;
    private FlightDto flightDto;
    private UserDto userDto;
    private Date date;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FlightDto getFlight() {
        return flightDto;
    }

    public void setFlight(FlightDto flightDto) {
        this.flightDto = flightDto;
    }

    public UserDto getUser() {
        return userDto;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
