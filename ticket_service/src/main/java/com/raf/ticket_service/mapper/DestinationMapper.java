package com.raf.ticket_service.mapper;

import com.raf.ticket_service.domain.Destination;
import com.raf.ticket_service.dto.DestinationDto;
import org.springframework.stereotype.Component;

@Component
public class DestinationMapper {

    public DestinationDto destinationToDestinationDto(Destination destination) {
        DestinationDto destinationDto = new DestinationDto();
        destinationDto.setId(destination.getId());
        destinationDto.setName(destination.getName());
        return destinationDto;
    }

    public Destination destinationDtoToDestination(DestinationDto destinationDto) {
        Destination destination = new Destination();
        destination.setId(destinationDto.getId());
        destination.setName(destinationDto.getName());
        return destination;
    }

}
