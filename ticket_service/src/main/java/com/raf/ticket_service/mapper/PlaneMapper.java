package com.raf.ticket_service.mapper;

import com.raf.ticket_service.domain.Plane;
import com.raf.ticket_service.dto.PlaneDto;
import org.springframework.stereotype.Component;

@Component
public class PlaneMapper {

    public PlaneDto planeToPlaneDto(Plane plane) {
        PlaneDto planeDto = new PlaneDto();
        planeDto.setName(plane.getName());
        planeDto.setNumberOfSeats(plane.getNumberOfSeats());
        return planeDto;
    }

    public Plane planeDtoToPlane(PlaneDto planeDto) {
        Plane plane = new Plane();
        plane.setId(planeDto.getId());
        plane.setName(planeDto.getName());
        plane.setNumberOfSeats(planeDto.getNumberOfSeats());
        return plane;
    }

}
