package com.application.model;

public class Stock {
    public Stock(String name, int recentAmount, int minAmount) {
        this.name = name;
        this.recentAmount = recentAmount;
        this.minAmount = minAmount;
    }

    public Stock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecentAmount() {
        return recentAmount;
    }

    public void setRecentAmount(int recentAmount) {
        this.recentAmount = recentAmount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    String name;
    int recentAmount;
    int minAmount;
}
