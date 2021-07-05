package com.raf.flight_service.service;

import com.raf.flight_service.dto.FlightCreateDto;
import com.raf.flight_service.dto.FlightDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightService {

    Page<FlightDto> findAll(Pageable pageable);

    FlightDto findById(Long id);

    FlightDto add(FlightCreateDto projectionCreateDto);

    void deleteById(Long id);

}
