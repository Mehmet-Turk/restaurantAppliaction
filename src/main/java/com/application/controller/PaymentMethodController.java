package com.application.controller;

import com.application.model.PaymentMethod;
import com.application.model.Reservation;
import com.application.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaymentMethodController {
    @Autowired
    PaymentMethodService paymentMethodService;
    // Endpoint
    // http://localhost:8080/api/paymentMethod
    // POST
    @PostMapping(value = "paymentMethod", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod paymentMethod){

        return ResponseEntity.ok().body(paymentMethodService.save(paymentMethod));

    }
    // Endpoint
    // http://localhost:8080/api/paymentMethod
    // GET
    @GetMapping(value = "paymentMethod", produces = "application/json")
    public Iterable<PaymentMethod> getAllPaymentMethod(){

        return paymentMethodService.findAll();


    }
    @GetMapping(value = "paymentMethod/{id}", produces = "application/json")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable long id){
        Optional<PaymentMethod> paymentMethod = paymentMethodService.findById(id);
        return paymentMethod.isPresent()? ResponseEntity.ok().body(paymentMethod.get()):ResponseEntity.notFound().build();
//        if(reservation.isPresent()){
//            return ResponseEntity.ok().body(reservation.get());
//        }
//        return ResponseEntity.notFound().build();

    }
    // Endpoint
    // http://localhost:8080/api/paymentMethod/2
    // DEL
    @DeleteMapping("paymentMethod/{id}")
    public ResponseEntity<Void> deletePaymentMethodById( @PathVariable long id){

        paymentMethodService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
