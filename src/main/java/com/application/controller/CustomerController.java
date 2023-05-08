package com.application.controller;

import com.application.model.Customer;
import com.application.model.PaymentMethod;
import com.application.service.CustomerService;
import com.application.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    // Endpoint
    // http://localhost:8080/api/customer
    // POST
    @PostMapping(value = "customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

        return ResponseEntity.ok().body(customerService.save(customer));

    }
    // Endpoint
    // http://localhost:8080/api/customer
    // GET
    @GetMapping(value = "customer", produces = "application/json")
    public Iterable<Customer> getAllCustomer(){

        return customerService.findAll();


    }
    @GetMapping(value = "customer/{id}", produces = "application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        Optional<Customer> customer = customerService.findById(id);
        return customer.isPresent()? ResponseEntity.ok().body(customer.get()):ResponseEntity.notFound().build();
//        if(reservation.isPresent()){
//            return ResponseEntity.ok().body(reservation.get());
//        }
//        return ResponseEntity.notFound().build();

    }
    // Endpoint
    // http://localhost:8080/api/customer/2
    // DEL
    @DeleteMapping("customer/{id}")
    public ResponseEntity<Void> deleteCustomerId( @PathVariable long id){

        customerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
