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
    boolean isMergeable;
    boolean isAvailable;

    public RestaurantTables(int tableNumber, int seat, boolean isMergeable, boolean isAvailable) {
        this.tableNumber = tableNumber;
        this.seat = seat;
        this.isMergeable = isMergeable;
        this.isAvailable = isAvailable;
    }

}
