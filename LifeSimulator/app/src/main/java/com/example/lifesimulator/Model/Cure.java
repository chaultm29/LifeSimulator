package com.example.lifesimulator.Model;

public class Cure {
    private int resourceID;
    private String name;
    private int fee;
    private String description;
    private Condition effect;

    public Cure(String name, int fee, String description,int resourceID, Condition effect) {

        this.name = name;
        this.fee = fee;
        this.description = description;
        this.resourceID = resourceID;
        this.effect = effect;
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

    public Condition getEffect() {
        return effect;
    }

    public void setEffect(Condition effect) {
        this.effect = effect;
    }
}
