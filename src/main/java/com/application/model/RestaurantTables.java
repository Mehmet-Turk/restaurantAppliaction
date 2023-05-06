package com.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@jakarta.persistence.Table(name = "`Table`")
public class RestaurantTables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long tableId;
    int tableNumber;
    int seat;
    boolean isMergeable;
    boolean isAvailable;

    public RestaurantTables() {
    }

    public RestaurantTables(int tableNumber, int seat, boolean isMergeable, boolean isAvailable) {
        this.tableNumber = tableNumber;
        this.seat = seat;
        this.isMergeable = isMergeable;
        this.isAvailable = isAvailable;
    }

}
