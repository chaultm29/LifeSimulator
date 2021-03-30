package com.example.lifesimulator.Model;

import java.util.ArrayList;

public class Identity {
    private String name;
    private int age;
    private boolean gender;
    private Condition condition;
    private Bank bank;
    private ArrayList<House> houses;
    private ArrayList<Item> items;

    public Identity() {
        this.name = "Min";
        this.age = 1;
        this.gender = false;
        condition = new Condition(30, 3, 100, 80, 80);
        bank = new Bank();
        houses = new ArrayList<>();
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public boolean buy(NetWorth thing){
        return bank.decrease(thing.price);
    }

    public Bank getBank() {
        return bank;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public boolean doLeisure(Leisure leisure){
        if(bank.decrease(leisure.getFee())){
            condition.effect(leisure.getEffect());
            return true;
        }
        return false;
    }

    public  boolean useCure(Cure cure) {
        if(bank.decrease(cure.getFee())){
            condition.effect(cure.getEffect());
            return true;
        }
        return false;
    }
}
