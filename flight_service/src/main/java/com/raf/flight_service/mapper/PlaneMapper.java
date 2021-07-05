package com.raf.flight_service.mapper;

import com.raf.flight_service.domain.Destination;
import com.raf.flight_service.domain.Plane;
import com.raf.flight_service.dto.DestinationCreateDto;
import com.raf.flight_service.dto.DestinationDto;
import com.raf.flight_service.dto.PlaneCreateDto;
import com.raf.flight_service.dto.PlaneDto;
import org.springframework.stereotype.Component;

@Component
public class PlaneMapper {

    public PlaneDto planeToPlaneDto(Plane plane) {
        PlaneDto planeDto = new PlaneDto();
        planeDto.setId(plane.getId());
        planeDto.setName(plane.getName());
        planeDto.setNumberOfSeats(plane.getNumberOfSeats());
        return planeDto;
    }

    public Plane planeCreateDtoToPlane(PlaneCreateDto planeCreateDto) {
        Plane plane = new Plane();
        plane.setName(planeCreateDto.getName());
        plane.setNumberOfSeats(planeCreateDto.getNumberOfSeats());
        return plane;
    }

}
