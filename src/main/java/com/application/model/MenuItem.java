package com.application.model;

public class MenuItem {
    int menuItemId;
    String itemName;
    String type;
    String description;
    double price;

    public MenuItem() {
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    boolean isAlcoholic;

    public MenuItem(String itemName, String type, String description, double price, boolean isAlcoholic) {
        this.itemName = itemName;
        this.type = type;
        this.description = description;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }
    //image

}
