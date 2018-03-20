package de.real.springboot.app.controllers;

import de.real.springboot.app.db.CustomerDb;
import de.real.springboot.app.helper.DummyDataHelper;
import de.real.springboot.app.models.Customer;
import de.real.springboot.app.models.Order;
import de.real.springboot.app.models.Route;
import de.real.springboot.app.service.DistanceSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    DistanceSvc distanceSvc;

    @Autowired
    CustomerDb customerDb;

    @GetMapping(path="")
    public List<Customer> getAllCustomers() {
        return DummyDataHelper.customers;
    }

    public ResponseEntity<Object> getValidResponse(Object object){
        return new ResponseEntity<Object>(object, new HttpHeaders(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getErrorResponse(List<String> errors){
        return new ResponseEntity<Object>( errors , new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


    @PostMapping("{id}/order")
    public ResponseEntity<Object> processCustomerOrder(@PathVariable("id") String id) {
        //Assumption some order Json which will use the custom request validator for the request and if successful
        // system will continue towards placing order
        Integer customerId = Integer.parseInt(id);
        Optional<Customer> customer = customerDb.getCustomer(customerId);

        if(customer.isPresent()){
            Optional<Route> route = distanceSvc.getOrderRouteObj(customer.get());
            if(route.isPresent()){
                return getValidResponse(new Order(customer.get() , route.get()));
            }
            return getErrorResponse(Arrays.asList("No route can be devised for this order"));
        }else{
            return getErrorResponse(Arrays.asList("Customer not present"));
        }
    }
}
