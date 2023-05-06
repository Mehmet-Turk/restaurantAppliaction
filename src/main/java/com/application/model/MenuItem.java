package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long menuItemId;
    String itemName;
    String type;
    String description;
    double price;
    boolean isAlcoholic;

    public MenuItem(String itemName, String type, String description, double price, boolean isAlcoholic) {
        this.itemName = itemName;
        this.type = type;
        this.description = description;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }
}
