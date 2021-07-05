package com.raf.flight_service.service.implementation;

import com.raf.flight_service.domain.Destination;
import com.raf.flight_service.domain.Plane;
import com.raf.flight_service.dto.DestinationCreateDto;
import com.raf.flight_service.dto.DestinationDto;
import com.raf.flight_service.dto.PlaneCreateDto;
import com.raf.flight_service.dto.PlaneDto;
import com.raf.flight_service.exception.NotFoundException;
import com.raf.flight_service.mapper.DestinationMapper;
import com.raf.flight_service.mapper.PlaneMapper;
import com.raf.flight_service.repository.DestinationRepository;
import com.raf.flight_service.repository.PlaneRepository;
import com.raf.flight_service.service.PlaneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlaneServiceImpl implements PlaneService {

    private PlaneRepository planeRepository;
    private PlaneMapper planeMapper;

    public PlaneServiceImpl(PlaneRepository planeRepository, PlaneMapper planeMapper) {
        this.planeRepository = planeRepository;
        this.planeMapper = planeMapper;
    }

    @Override
    public Page<PlaneDto> findAll(Pageable pageable) {
        return planeRepository.findAll(pageable)
                .map(planeMapper::planeToPlaneDto);
    }

    @Override
    public PlaneDto findById(Long id) {
        return planeRepository.findById(id)
                .map(planeMapper::planeToPlaneDto)
                .orElseThrow(() -> new NotFoundException(String.format("Plane with id: %d does not exists.", id)));
    }

    @Override
    public PlaneDto add(PlaneCreateDto planeCreateDto) {
        Plane plane = planeMapper.planeCreateDtoToPlane(planeCreateDto);
        planeRepository.save(plane);
        return planeMapper.planeToPlaneDto(plane);
    }

    @Override
    public void deleteById(Long id) {
        // uslov da avion koji se brise nije dodat nijednom letu
        planeRepository.deleteById(id);
    }

}
