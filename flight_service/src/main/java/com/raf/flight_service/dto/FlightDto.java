package com.raf.flight_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raf.flight_service.domain.Destination;
import com.raf.flight_service.domain.Plane;

import javax.persistence.OneToOne;
import java.math.BigDecimal;

public class FlightDto {

    private Long id;
    @JsonProperty("plane")
    private PlaneDto planeDto;
    @JsonProperty("destination")
    private DestinationDto destinationDto;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlaneDto getPlaneDto() {
        return planeDto;
    }

    public void setPlaneDto(PlaneDto planeDto) {
        this.planeDto = planeDto;
    }

    public DestinationDto getDestinationDto() {
        return destinationDto;
    }

    public void setDestinationDto(DestinationDto destinationDto) {
        this.destinationDto = destinationDto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
