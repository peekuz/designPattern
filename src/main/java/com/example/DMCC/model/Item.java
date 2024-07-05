package com.example.model;

import lombok.Data;

@Data
public class Item {
    public Item(String type, String name, int quantity, double amount) {
        this.quantity = quantity;
        this.amount = amount;
        this.type = type;
        this.name = name;
    }

    private String type;
    private double amount;
    private String name;
    private int quantity;
}
