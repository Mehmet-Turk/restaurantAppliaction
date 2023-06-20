package com.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long orderId;
    String itemName;
    int quantity;
    LocalDate date;
    LocalTime time;
    @Column(name = "item_price")
    private double itemPrice;

    int tableNumber;

    //OneToMany we should create a list in many relations.


    public RestaurantOrders(String itemName, int quantity, LocalDate date, LocalTime time, double itemPrice, int tableNumber) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.date = date;
        this.time = time;
        this.itemPrice = itemPrice;
        this.tableNumber = tableNumber;
    }
}
