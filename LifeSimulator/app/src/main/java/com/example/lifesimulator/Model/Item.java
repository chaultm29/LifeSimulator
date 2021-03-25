package com.example.lifesimulator.Model;

public class Item extends NetWorth{
    public Item() {
    }

    public Item(String code, String name, float price, String description, boolean isOwner) {
        super(code, name, price, description, isOwner);
    }
}
