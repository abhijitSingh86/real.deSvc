package de.real.springboot.app.models;

public class Route {

    private final Drone drone;
    private final Store store;
    private final Double totalDistance;


    public Route(Drone drone, Store store, Double totalDistance) {
        this.drone = drone;
        this.store = store;
        this.totalDistance = totalDistance;
    }

    public Drone getDrone() {
        return drone;
    }

    public Store getStore() {
        return store;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }
}
