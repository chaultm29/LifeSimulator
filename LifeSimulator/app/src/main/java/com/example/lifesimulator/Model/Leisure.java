package com.example.lifesimulator.Model;

public class Leisure {
    private String name;
    private String requiredItem;
    private int fee;
    private String description;
    private int resourceID;
    private  Condition effect;

    public Leisure(){

    }

    public Leisure(String name, String requiredItem, int fee, String description, int resourceID) {
        this.name = name;
        this.requiredItem = requiredItem;
        this.fee = fee;
        this.description = description;
        this.resourceID = resourceID;
    }

    public Leisure(String name, int fee, String description, int resourceID, Condition effect) {
        this.name = name;
        this.fee = fee;
        this.description = description;
        this.resourceID = resourceID;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public Condition getEffect() {
        return effect;
    }

    public void setEffect(Condition effect) {
        this.effect = effect;
    }
}
