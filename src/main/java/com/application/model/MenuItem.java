package com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long menuItemId;
    String itemName;
    String type;
    String ingredients;
    double price;
    boolean isAlcoholic;

    public MenuItem(String itemName, String type, String ingredients, double price, boolean isAlcoholic) {
        this.itemName = itemName;
        this.type = type;
        this.ingredients = ingredients;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }
}
