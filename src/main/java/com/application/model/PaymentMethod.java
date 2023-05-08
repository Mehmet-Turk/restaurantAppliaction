package com.application.model;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long paymentId;
    String description;

    public PaymentMethod(String description) {
    }

}
