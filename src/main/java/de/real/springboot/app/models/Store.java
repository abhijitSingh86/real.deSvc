package de.real.springboot.app.models;

public class Store {
    private final int id;
    private final String name;
    private final String address;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Store( int id,String name, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }
}
