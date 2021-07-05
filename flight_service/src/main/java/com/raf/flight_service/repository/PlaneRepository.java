package com.raf.flight_service.repository;

import com.raf.flight_service.domain.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
