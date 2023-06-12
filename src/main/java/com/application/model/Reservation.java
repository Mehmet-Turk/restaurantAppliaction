package com.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
//    @ManyToOne
//    Customer customer;
    @ManyToMany
    private List<RestaurantTables> table = new ArrayList<>();
    LocalDate date;
    LocalTime time;
    boolean addBabyChair;
    String fullName;
    int numberOfPeople;

    String phoneNumber;
    String email;
    String roomNumber;

    public Reservation(List<RestaurantTables> table, LocalDate date, LocalTime time, boolean addBabyChair, String fullName, int numberOfPeople, String phoneNumber, String email, String roomNumber) {
        this.table = table;
//        String europeanDatePattern = "dd.MM.yyyy";
//        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
//        this.date = LocalDate.parse(europeanDateFormatter.format(date));
        this.date = date;
        this.time = time;
        this.addBabyChair = addBabyChair;
        this.fullName = fullName;
        this.numberOfPeople = numberOfPeople;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roomNumber = roomNumber;
    }
}
