package com.application.service;

import com.application.model.Customer;
import com.application.model.Reservation;

import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(long id);
    Customer save(Customer customer);
    void deleteById( long id);
}
