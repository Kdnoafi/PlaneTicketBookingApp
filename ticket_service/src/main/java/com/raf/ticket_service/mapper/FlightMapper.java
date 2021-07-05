package com.raf.ticket_service.mapper;

import com.raf.ticket_service.domain.Flight;
import com.raf.ticket_service.dto.FlightDto;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    private PlaneMapper planeMapper;
    private DestinationMapper destinationMapper;

    public FlightMapper(PlaneMapper planeMapper, DestinationMapper destinationMapper) {
        this.planeMapper = planeMapper;
        this.destinationMapper = destinationMapper;
    }

    public FlightDto flightToFlightDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setPlaneDto(planeMapper.planeToPlaneDto(flight.getPlane()));
        flightDto.setDestinationDto(destinationMapper.destinationToDestinationDto(flight.getDestination()));
        flightDto.setPrice(flight.getPrice());
        return flightDto;
    }

    public Flight flightDtoToFlight(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setPrice(flightDto.getPrice());
        flight.setPlane(planeMapper.planeDtoToPlane(flightDto.getPlaneDto()));
        flight.setDestination(destinationMapper.destinationDtoToDestination(flightDto.getDestinationDto()));
        return flight;
    }

}
