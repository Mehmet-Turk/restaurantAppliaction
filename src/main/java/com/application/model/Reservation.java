package com.application.model;

import com.application.repositories.AccountRepositoryImpl;
import com.application.repositories.ReservationRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Reservation {

    long id;
    int tableNumber;
    String telephoneNumber;
    String email;
    int guests;
    boolean vegan;
    LocalDate date;

    public Reservation() {
    }

    public Reservation(int tableNumber, String telephoneNumber, String email, int guests, boolean vegan, LocalDate date) {
        this.id = Sequence.getNextSequence();
        this.tableNumber = tableNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.guests = guests;
        this.vegan = vegan;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

   public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
