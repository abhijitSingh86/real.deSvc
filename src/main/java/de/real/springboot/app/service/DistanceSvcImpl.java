package de.real.springboot.app.service;

import de.real.springboot.app.helper.DummyDataHelper;
import de.real.springboot.app.models.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistanceSvcImpl  implements DistanceSvc{


    private double distanceFrom(Store store,Customer customer){
        return distanceFrom(customer.getName(),store.getName());
    }

    private double distanceFrom(String from,String to){
        Pair p  = DummyDataHelper.toStoreDistanceMap.get(from)
                .stream()
                .filter(x-> x.getFirst().equalsIgnoreCase(to))
                .collect(Collectors.toList()).get(0);
        // I had to look into the reason for why java streams changes the type .. may be internal optimization but i
        // need to look more into it.For now dirty fix
        if(p.getSecond()  instanceof Integer)
            return ((Double)(((Integer)p.getSecond()).intValue()+0.0d));
        return (double) p.getSecond();
    }

    private double distanceFrom(Store store,Drone drone){
        return distanceFrom(drone.getName(),store.getName());
    }

    @Override
    public Optional<Route> getOrderRouteObj(Customer customer) {
        //Calculate Distance of stores w.r.t customer and store it into list
        List<Pair> storeCustomerDistancePair = DummyDataHelper.stores.stream().map(store->
            new Pair<>(store,distanceFrom(store,customer))
        ).sorted(Comparator.comparing(Pair::getSecond)).collect(Collectors.toList());


        /*
        Get Drone locations and add the distance of drone to store into storeCustomerDistance list
        Sort the list with minimum time and return the head of the list
         because head will be the closest location from the customer.
         Later proper algorithm can be implemented which will iterate to find the
         shortest path but for now that seems to be an overkill as there are no multiple store pickup requirement
         */

       List<Route> routes =  DummyDataHelper.drones.stream().map(drone -> {
           return  storeCustomerDistancePair.stream().map(storePair->{
               Store store = ((Store) storePair.getFirst());
               double distanceFromCustomer = (double) storePair.getSecond();
            return   new Route(drone , store ,distanceFromCustomer+ distanceFrom(store, drone));
           })
                    .collect(Collectors.toList());
        }).flatMap(f->f.stream()).sorted(Comparator.comparing(Route::getTotalDistance)).collect(Collectors.toList());

       if(routes.size() >0){
           return Optional.of(routes.get(0));
       }
       return Optional.empty();
    }
}
