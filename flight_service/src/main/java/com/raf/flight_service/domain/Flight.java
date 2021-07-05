package com.raf.flight_service.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Plane plane;
    @OneToOne
    private Destination destination;
    private BigDecimal price;

    public Flight() {

    }

    public Flight(Plane plane, Destination destination, BigDecimal price) {
        this.plane = plane;
        this.destination = destination;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
