package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long tableId;
    int tableNumber;
    int seat;
    boolean isMergeable;
    boolean isAvailable;

    public Table() {
    }

    public Table(int tableNumber, int seat, boolean isMergeable, boolean isAvailable) {
        this.tableNumber = tableNumber;
        this.seat = seat;
        this.isMergeable = isMergeable;
        this.isAvailable = isAvailable;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public boolean isMergeable() {
        return isMergeable;
    }

    public void setMergeable(boolean mergeable) {
        isMergeable = mergeable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
