package com.raf.flight_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;

public class PlaneCreateDto {

    private String name;
    @Min(50)
    @JsonProperty("number_of_seats")
    private Integer numberOfSeats;

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
