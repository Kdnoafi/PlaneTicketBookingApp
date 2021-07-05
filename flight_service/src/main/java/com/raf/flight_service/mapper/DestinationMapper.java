package com.raf.flight_service.mapper;

import com.raf.flight_service.domain.Destination;
import com.raf.flight_service.dto.DestinationCreateDto;
import com.raf.flight_service.dto.DestinationDto;
import org.springframework.stereotype.Component;

@Component
public class DestinationMapper {

    public DestinationDto destinationToDestinationDto(Destination destination) {
        DestinationDto destinationDto = new DestinationDto();
        destinationDto.setId(destination.getId());
        destinationDto.setName(destination.getName());
        return destinationDto;
    }

    public Destination destinationCreateDtoToDestination(DestinationCreateDto destinationCreateDto) {
        Destination destination = new Destination();
        destination.setName(destinationCreateDto.getName());
        return destination;
    }

}
