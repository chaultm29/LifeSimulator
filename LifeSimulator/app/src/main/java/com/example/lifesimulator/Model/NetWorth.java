package com.example.lifesimulator.Model;

public abstract class NetWorth {
    protected String code;
    protected String name ;
    protected int price ;
    protected String description;
    protected boolean isOwner;

    public NetWorth() {
    }

    public NetWorth(String code, String name, int price, String description, boolean isOwner) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isOwner = isOwner;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
