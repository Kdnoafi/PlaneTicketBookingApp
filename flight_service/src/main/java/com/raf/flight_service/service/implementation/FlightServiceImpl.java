package com.raf.flight_service.service.implementation;

import com.raf.flight_service.domain.Flight;
import com.raf.flight_service.dto.FlightCreateDto;
import com.raf.flight_service.dto.FlightDto;
import com.raf.flight_service.exception.NotFoundException;
import com.raf.flight_service.mapper.FlightMapper;
import com.raf.flight_service.repository.FlightRepository;
import com.raf.flight_service.service.FlightService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private FlightMapper flightMapper;

    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public Page<FlightDto> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable)
                .map(flightMapper::flightToFlightDto);
    }

    @Override
    public FlightDto findById(Long id) {
        return flightRepository.findById(id)
                .map(flightMapper::flightToFlightDto)
                .orElseThrow(() -> new NotFoundException(String.format("Flight with id: %d does not exists.", id)));
    }

    @Override
    public FlightDto add(FlightCreateDto flightCreateDto) {
        Flight flight = flightMapper.flightCreateDtoToFlight(flightCreateDto);
        flightRepository.save(flight);
        return flightMapper.flightToFlightDto(flight);
    }

    @Override
    public void deleteById(Long id) {
        // treba korisnicima koji su kupili karte za ovaj let da se posalje mejl obavestenje,
        // da im se oduzmu milje, i da se let i karta markira kao "canceled"
        flightRepository.deleteById(id);
    }

}
