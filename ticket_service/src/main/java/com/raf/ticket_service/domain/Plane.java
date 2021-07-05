package com.raf.ticket_service.domain;

public class Plane {

    private Long id;
    private String name;
    private Integer numberOfSeats;

    public Plane() {

    }

    public Plane(Integer numberOfSeats) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

}
