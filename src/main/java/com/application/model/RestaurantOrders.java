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
    LocalDate date;
    LocalTime time;
    @OneToMany
    private List<MenuItem> menuItem = new ArrayList<>();
    //OneToMany we should create a list in many relations.
    public RestaurantOrders(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }
}
