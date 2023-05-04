package com.application.service;

import com.application.model.PaymentMethod;
import com.application.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{
    @Autowired
    PaymentMethodRepository paymentMethodRepository;
    @Override
    public Iterable<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public Optional<PaymentMethod> findById(long id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deleteById(long id) {
        paymentMethodRepository.deleteById(id);
    }
}
