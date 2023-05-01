package com.application.model;

public class Table {
    int tableId;
    int seat;

    public Table(int seat, boolean isMergeable, boolean isAvailable) {
        this.seat = seat;
        this.isMergeable = isMergeable;
        this.isAvailable = isAvailable;
    }

    public Table() {
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
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

    boolean isMergeable;
    boolean isAvailable;

}
