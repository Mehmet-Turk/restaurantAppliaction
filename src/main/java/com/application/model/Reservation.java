package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity

public class Reservation {
//    reservationId integer PRIMARY KEY,
//    customerId integer,
//    tableId integer,
//    startTime DATETIME,
//    startDate DATE,
//    addBabyChair boolean
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    long reservationId;
    Customer customer;
    Table table;
    LocalDate date;
    LocalTime time;
    boolean addBabyChair;


    public Reservation() {
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isAddBabyChair() {
        return addBabyChair;
    }

    public void setAddBabyChair(boolean addBabyChair) {
        this.addBabyChair = addBabyChair;
    }

    public Reservation(Customer customer, Table table, LocalDate date, LocalTime time, boolean addBabyChair) {
        this.customer = customer;
        this.table = table;
        this.date = date;
        this.time = time;
        this.addBabyChair = addBabyChair;
    }
}
