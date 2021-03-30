package com.example.lifesimulator.Model;

public class House extends NetWorth {
    private float rent;

    public House() {
    }

    public House(String code, String name, int price, String description, boolean isOwner, float rent) {
        super(code, name, price, description, isOwner);
        this.rent = rent;
    }

    public float getRent() {
        return rent;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }
}
