package com.raf.flight_service.service.implementation;

import com.raf.flight_service.domain.Destination;
import com.raf.flight_service.dto.DestinationCreateDto;
import com.raf.flight_service.dto.DestinationDto;
import com.raf.flight_service.exception.NotFoundException;
import com.raf.flight_service.mapper.DestinationMapper;
import com.raf.flight_service.repository.DestinationRepository;
import com.raf.flight_service.service.DestinationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DestinationServiceImpl implements DestinationService {

    private DestinationRepository destinationRepository;
    private DestinationMapper destinationMapper;

    public DestinationServiceImpl(DestinationRepository destinationRepository, DestinationMapper destinationMapper) {
        this.destinationRepository = destinationRepository;
        this.destinationMapper = destinationMapper;
    }

    @Override
    public Page<DestinationDto> findAll(Pageable pageable) {
        return destinationRepository.findAll(pageable)
                .map(destinationMapper::destinationToDestinationDto);
    }

    @Override
    public DestinationDto findById(Long id) {
        return destinationRepository.findById(id)
                .map(destinationMapper::destinationToDestinationDto)
                .orElseThrow(() -> new NotFoundException(String.format("Destination with id: %d does not exists.", id)));
    }

    @Override
    public DestinationDto add(DestinationCreateDto destinationCreateDto) {
        Destination destination = destinationMapper.destinationCreateDtoToDestination(destinationCreateDto);
        destinationRepository.save(destination);
        return destinationMapper.destinationToDestinationDto(destination);
    }

    @Override
    public void deleteById(Long id) {
        destinationRepository.deleteById(id);
    }

}
