package com.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long customerId;
    @OneToMany
    private List<PaymentMethod> paymentMethod = new ArrayList<>();
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
    boolean isGuest;

    public Customer(PaymentMethod paymentMethod, String firstName, String lastName, String phoneNumber, String email, String address, boolean isGuest) {
        this.paymentMethod = Collections.singletonList(paymentMethod);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isGuest = isGuest;
    }
}
