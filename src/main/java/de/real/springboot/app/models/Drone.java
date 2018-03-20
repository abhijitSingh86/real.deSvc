package de.real.springboot.app.models;

public class Drone {

    private final long id;
    private final String name;
    private final String address;

    public Drone(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

