package com.raf.flight_service.repository;

import com.raf.flight_service.domain.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
