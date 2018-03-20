package de.real.springboot.app.models;

import java.text.DecimalFormat;

public class Order {

    private final Customer customer;

    private final Store store;

    private final Drone drone;

    private final Double distance;
    private final Double timeTaken;

    public Order(Customer customer, Store store, Drone drone , Double distance) {
        this.customer = customer;
        this.store = store;
        this.drone = drone;
        this.distance = distance;
        this.timeTaken = this.distance /60;

    }

    public Order(Customer customer, Route route) {
        this.customer = customer;
        this.store = route.getStore();
        this.drone = route.getDrone();
        this.distance = route.getTotalDistance();
        this.timeTaken = this.distance /60;

    }

    public Double getDistance() {
        return distance;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Store getStore() {
        return store;
    }

    public Drone getDrone() {
        return drone;
    }
}
