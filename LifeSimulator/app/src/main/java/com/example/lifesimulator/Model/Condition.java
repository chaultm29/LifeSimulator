package com.example.lifesimulator.Model;

public class Condition {
    private int height;
    private int weight;
    private int health;
    private int happiness;
    private int intelligence;

    private int maxHeight;

    public Condition() {
        this.height = AppDataStore.Generate(45, 55);
        this.weight = AppDataStore.Generate(3, 5);
        this.health = AppDataStore.Generate(60, 80);
        this.happiness = AppDataStore.Generate(60, 80);
        this.intelligence = AppDataStore.Generate(40, 60);
        this.maxHeight = AppDataStore.Generate(145, 190);
    }

    public Condition(int height, int weight, int health, int happiness, int intelligence) {
        this.height = height;
        this.weight = weight;
        this.health = health;
        this.happiness = happiness;
        this.intelligence = intelligence;
    }

    public int UpHeight(int age){
        if (age < 28){
            int remainH = maxHeight - this.height;
            int addH = AppDataStore.Generate(0, remainH);
            this.height =  addH;
            return addH;
        }
        return 0;
    }

    public void effect(Condition other) {
        this.height += other.getHeight();
        this.weight += other.getWeight();
        this.health += other.getHealth();
        this.happiness += other.getHappiness();
        this.intelligence += other.getIntelligence();
        AppDataStore.UpdateConditionView();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
