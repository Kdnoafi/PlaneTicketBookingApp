package com.raf.flight_service.runner;

import com.raf.flight_service.domain.Destination;
import com.raf.flight_service.domain.Flight;
import com.raf.flight_service.domain.Plane;
import com.raf.flight_service.repository.DestinationRepository;
import com.raf.flight_service.repository.FlightRepository;
import com.raf.flight_service.repository.PlaneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private DestinationRepository destinationRepository;
    private PlaneRepository planeRepository;
    private FlightRepository flightRepository;

    public TestDataRunner(DestinationRepository destinationRepository, PlaneRepository planeRepository, FlightRepository flightRepository) {
            this.destinationRepository = destinationRepository;
            this.planeRepository = planeRepository;
            this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            Destination destination1 = new Destination("dest1");
            Destination destination2 = new Destination("dest2");
            destinationRepository.save(destination1);
            destinationRepository.save(destination2);

            Plane plane1 = new Plane("plane1", 150);
            Plane plane2 = new Plane("plane2", 200);
            planeRepository.save(plane1);
            planeRepository.save(plane2);

            flightRepository.save(new Flight(plane1, destination1, BigDecimal.TEN));
            flightRepository.save(new Flight(plane1, destination2, BigDecimal.TEN));
            flightRepository.save(new Flight(plane2, destination2, BigDecimal.TEN));
    }

}
