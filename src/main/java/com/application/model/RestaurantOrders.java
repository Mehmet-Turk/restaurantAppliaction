package com.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class RestaurantOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long orderId;
    @ManyToOne
    Customer customer;
    @OneToMany
    private List<MenuItem> menuItem = new ArrayList<>();

    public RestaurantOrders(Customer customer, List<MenuItem> menuItem) {
        this.customer = customer;
        this.menuItem = menuItem;
    }
}
