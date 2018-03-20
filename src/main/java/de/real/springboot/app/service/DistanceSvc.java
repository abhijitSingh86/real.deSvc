package de.real.springboot.app.service;

import de.real.springboot.app.models.Customer;
import de.real.springboot.app.models.Route;

import java.util.Optional;

public interface DistanceSvc {



    Optional<Route> getOrderRouteObj(Customer customer);
//    double getDistance(Customer customer1 , Customer customer2);
//    double getDistance(Store store1 ,Store store2);
//    double getDistance(String address1,String address2);
}
