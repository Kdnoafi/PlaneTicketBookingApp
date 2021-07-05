package com.raf.ticket_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaneDto {

    private Long id;
    private String name;
    @JsonProperty("number_of_seats")
    private Integer numberOfSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

}
