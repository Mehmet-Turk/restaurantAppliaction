package com.application.service;

import com.application.model.PaymentMethod;
import com.application.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentMethodService{
    Iterable<PaymentMethod> findAll();
    Optional<PaymentMethod> findById(long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    void deleteById( long id);
}
