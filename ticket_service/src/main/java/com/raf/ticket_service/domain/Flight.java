package com.raf.ticket_service.domain;

import java.math.BigDecimal;

public class Flight {

    private Long id;
    private Plane plane;
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
