package com.example.lifesimulator.Model;

public class Condition {
    private float height;
    private float weight;
    private int health;
    private int happiness;
    private int intelligence;

    public Condition() {
        //random condition in here
    }

    public Condition(float height, float weight, int health, int happiness, int intelligence) {
        this.height = height;
        this.weight = weight;
        this.health = health;
        this.happiness = happiness;
        this.intelligence = intelligence;
    }

    public void effect(Condition other) {
        this.height += other.getHeight();
        this.weight += other.getWeight();
        this.health += other.getHealth();
        this.happiness += other.getHappiness();
        this.intelligence += other.getIntelligence();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
