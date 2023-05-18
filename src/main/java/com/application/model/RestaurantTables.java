package com.application.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long tableId;
    int tableNumber;
    int seat;
    boolean mergeable;
    boolean available;

    public RestaurantTables(int tableNumber, int seat, boolean mergeable, boolean available) {
        this.tableNumber = tableNumber;
        this.seat = seat;
        this.mergeable = mergeable;
        this.available = available;
    }

}
