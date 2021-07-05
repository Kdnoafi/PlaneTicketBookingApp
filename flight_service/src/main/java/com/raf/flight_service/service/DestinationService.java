package com.raf.flight_service.service;

import com.raf.flight_service.dto.DestinationDto;
import com.raf.flight_service.dto.DestinationCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DestinationService {

    Page<DestinationDto> findAll(Pageable pageable);

    DestinationDto findById(Long id);

    DestinationDto add(DestinationCreateDto movieCreateDto);

    void deleteById(Long id);

}
