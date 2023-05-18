package com.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long reservationId;
    @ManyToOne
    Customer customer;
    @OneToMany
    private List<RestaurantTables> table = new ArrayList<>();
    LocalDate date;
    LocalTime time;
    boolean addBabyChair;

    public Reservation(Customer customer, List<RestaurantTables> table, LocalDate date, LocalTime time, boolean addBabyChair) {
//        this.table = Collections.singletonList(table);
        this.customer = customer;
        this.table = table;
        this.date = date;
        this.time = time;
        this.addBabyChair = addBabyChair;
    }
}
