package com.raf.ticket_service.domain;

public class Destination {

    private Long id;
    private String name;

    public Destination() {

    }

    public Destination(String name) {
        this.name = name;
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

}
