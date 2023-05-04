package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity



public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long orderId;
    Customer customer;
    MenuItem menuItem;

    public Order() {
    }
}
