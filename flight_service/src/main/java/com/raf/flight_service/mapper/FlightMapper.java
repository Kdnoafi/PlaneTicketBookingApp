package com.raf.flight_service.mapper;

import com.raf.flight_service.domain.Flight;
import com.raf.flight_service.dto.FlightCreateDto;
import com.raf.flight_service.dto.FlightDto;
import com.raf.flight_service.exception.NotFoundException;
import com.raf.flight_service.repository.DestinationRepository;
import com.raf.flight_service.repository.PlaneRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    private PlaneRepository planeRepository;
    private DestinationRepository destinationRepository;
    private PlaneMapper planeMapper;
    private DestinationMapper destinationMapper;

    public FlightMapper(PlaneRepository planeRepository, DestinationRepository destinationRepository, PlaneMapper planeMapper,
                        DestinationMapper destinationMapper) {
        this.planeRepository = planeRepository;
        this.destinationRepository = destinationRepository;
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

    public Flight flightCreateDtoToFlight(FlightCreateDto flightCreateDto) {
        Flight flight = new Flight();
        flight.setPlane(planeRepository.findById(flightCreateDto.getPlaneId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("Plane with id: %d does not exist.", flightCreateDto.getPlaneId()))));
        flight.setDestination(destinationRepository.findById(flightCreateDto.getDestinationId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("Destination with id: %d does not exist.", flightCreateDto.getDestinationId()))));
        flight.setPrice(flightCreateDto.getPrice());
        return flight;
    }

}
