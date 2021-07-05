package com.raf.flight_service.service;

import com.raf.flight_service.dto.PlaneCreateDto;
import com.raf.flight_service.dto.PlaneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlaneService {

    Page<PlaneDto> findAll(Pageable pageable);

    PlaneDto findById(Long id);

    PlaneDto add(PlaneCreateDto screenCreateDto);

    void deleteById(Long id);

}
