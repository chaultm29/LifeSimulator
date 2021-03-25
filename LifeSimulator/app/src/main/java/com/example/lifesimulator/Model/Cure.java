package com.example.lifesimulator.Model;

public class Cure {
    private int resourceID;
    private String name;
    private float fee;
    private String description;

    public Cure(String name, float fee, String description,int resourceID) {

        this.name = name;
        this.fee = fee;
        this.description = description;
        this.resourceID = resourceID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
