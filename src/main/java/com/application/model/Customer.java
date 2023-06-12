package com.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long customerId;
//    @OneToMany
//    private List<PaymentMethod> paymentMethod = new ArrayList<>();
    String fullName;

    String phoneNumber;
    String email;
    int roomNumber;
//    boolean isGuest;

    public Customer(String fullName, String phoneNumber, String email,int roomNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roomNumber = roomNumber;
    }
}
