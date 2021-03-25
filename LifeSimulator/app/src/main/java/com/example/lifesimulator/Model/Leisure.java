package com.example.lifesimulator.Model;

public class Leisure {
    private String name;
    private String requiredItem;
    private float fee;
    private String description;
    private int resourceID;

    public Leisure(){

    }

    public Leisure(String name, String requiredItem, float fee, String description, int resourceID) {
        this.name = name;
        this.requiredItem = requiredItem;
        this.fee = fee;
        this.description = description;
        this.resourceID = resourceID;
    }

    public Leisure(String name, float fee, String description, int resourceID) {
        this.name = name;
        this.fee = fee;
        this.description = description;
        this.resourceID = resourceID;
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

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
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
}
