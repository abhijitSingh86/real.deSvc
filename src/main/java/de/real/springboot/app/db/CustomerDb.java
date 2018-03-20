package de.real.springboot.app.db;

import de.real.springboot.app.models.Customer;

import java.util.Optional;

public interface  CustomerDb {

    Optional<Customer> getCustomer(Integer id);
}
