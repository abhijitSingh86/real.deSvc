package de.real.springboot.app.helper;

import de.real.springboot.app.models.Customer;
import de.real.springboot.app.models.Drone;
import de.real.springboot.app.models.Pair;
import de.real.springboot.app.models.Store;

import java.util.*;

public class DummyDataHelper {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Store> stores= new ArrayList<>();
    public static List<Drone> drones= new ArrayList<>();

    /*
    I was thinking to make it like below for proper type safety but seems hardcoding complicating the task so used
    another strategy to simplify.

    public static Map<String,List<Pair<Store,Double>>> customerToStoreDistanceMap = new HashMap<>();
    public static Map<Drone,List<Pair<Store,Double>>> droneToStoreDistanceMap = new HashMap<>();
    */

    public static Map<String,List<Pair<String,Double>>> toStoreDistanceMap = new HashMap<String,List<Pair<String,Double>>>();

    private static void populateCustomer(){
            int i=1;
        customers.add(new Customer(i++,"C1" , "Kronprinzenstraße 88, 40217 Düsseldorf"));
        customers.add(new Customer(i++,"C2" , "Kaiserstraße 2, 40479 Düsseldorf"));
        customers.add(new Customer(i++,"C3" , "Wildenbruchstraße 2, 40545 Düsseldorf"));
        customers.add(new Customer(i++,"C4" , "Schlesische Straße 5, 40231 Düsseldorf"));
    }

    private static void populateStores(){
        int i=1;
        stores.add(new Store(i,"S"+i++ ,"Schiessstraße 31, 40549 Düsseldorf"));
        stores.add(new Store(i,"S"+i++ ,"Friedrichstraße 152, 40217 Düsseldorf"));
        stores.add(new Store(i,"S"+i++ ,"Breslauer Str. 2, 41460 Neuss"));
        stores.add(new Store(i,"S"+i++ ,"Bataverstraße 93, 41462 Neuss"));
        stores.add(new Store(i,"S"+i++ ,"Am Sandbach 30, 40878 Ratingen"));
    }

    private static void populateDrones(){
        int i=1;
        drones.add(new Drone(i,"D"+i++ ,"Metrostrasse 12, 40235 Düsseldorf"));
        drones.add(new Drone(i,"D"+i++ ,"Am Albertussee 1, 40549 Düsseldorf"));
    }

    private static void populateDistanceMap(){
        // Hardcoded distance from google Maps

        toStoreDistanceMap .put("C1" , Arrays.asList(new Pair("S1" , 6.0),new Pair("S2",2.0)  ,new Pair("S3",5.0) , new Pair("S4",9.0) , new Pair("S5",17.0)));
        toStoreDistanceMap .put("C2" , Arrays.asList(new Pair("S1" , 8.0),new Pair("S2",4.0)  ,new Pair("S3",9.0) , new Pair("S4",10.0) , new Pair("S5",12.0)));
        toStoreDistanceMap .put("C3" , Arrays.asList(new Pair("S1" , 4.0),new Pair("S2",4.0)  ,new Pair("S3",7.0) , new Pair("S4",6.0) , new Pair("S5",16.0)));
        toStoreDistanceMap .put("C4" , Arrays.asList(new Pair("S1" , 10.0),new Pair("S2",6.0)  ,new Pair("S3",10.0) , new Pair("S4",13.0) , new Pair("S5",15.0)));
        toStoreDistanceMap .put("D1" , Arrays.asList(new Pair("S1" , 11.0),new Pair("S2",6.0)  ,new Pair("S3",10.0) , new Pair("S4",13.0) , new Pair("S5",11.0)));
        toStoreDistanceMap .put("D2" , Arrays.asList(new Pair("S1" , 1.0),new Pair("S2",7.0)  ,new Pair("S3",7.0) , new Pair("S4",5.0) , new Pair("S5",14.0)));
    }

    static{
        populateCustomer();
        populateStores();
        populateDrones();
        populateDistanceMap();
    }
}
