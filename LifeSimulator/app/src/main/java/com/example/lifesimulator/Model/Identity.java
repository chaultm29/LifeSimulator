package com.example.lifesimulator.Model;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

public class Identity {
    private String name;
    private int age;
    private boolean gender;
    private Condition condition;
    private Bank bank;
    private ArrayList<House> houses;
    private ArrayList<Item> items;
    private University university;
    private Job job;
    private Degree degree;
    private String strDegree;

    public Identity() {
        this.name = "Min";
        this.age = 1;
        this.gender = false;
        condition = new Condition();
        bank = new Bank();
        houses = new ArrayList<>();
        items = new ArrayList<>();
        degree = Degree.NONE;
        this.strDegree = "Chưa đi học";
    }

    public void EventBirth(Context context){
        LifeEvent lifeEvent = AppDataStore.GetLifeEvent(Milestone.BIRTH);
        if (lifeEvent != null) {
            AppDialog.InfoDialog(context, lifeEvent.getContent(), null);
            this.bank = lifeEvent.getEffectBank();
            this.condition = lifeEvent.getEffectCondition();
        } else AppDialog.InfoDialog(context, "Bạn sinh ra bình thường như bao đứa trẻ bình thường khác", null);
    }

    public void GrowUp(View view){
        this.age ++;
        this.bank.newYear();
        this.condition.UpHeight(this.age);
        LifeEvent lifeEvent = AppDataStore.GetLifeEvent(Milestone.NEWAGE);
        if (lifeEvent != null) {
            AppDialog.InfoDialog(view.getContext(), lifeEvent.getContent(), null);
            this.bank.effect(lifeEvent.getEffectBank());
            this.condition.effect(lifeEvent.getEffectCondition());
        } else AppDialog.InfoDialog(view.getContext(), "Năm nay không có gì nổi bật", null);//Chắc sẽ ko vào
        checkDegree();
    }

    private void checkDegree(){
        if (age < 6){
            this.degree = Degree.NONE;
            this.strDegree = "Chưa đi học";
        } else if (age < 11){
            this.degree = Degree.LEVEL1;
            this.strDegree = "Cấp 1";
        } else if (age < 15){
            this.degree = Degree.LEVEL2;
            this.strDegree = "Cấp 2";
        } else if (age < 18){
            this.degree = Degree.LEVEL3;
            this.strDegree = "Cấp 3";
        } else if (age < 22){
            if (this.university == null){
                this.degree = Degree.SELECTUNI;
                this.strDegree = "Hết cấp 3";
            } else {
                this.degree = Degree.UNIVERSITY;
                this.strDegree = "Đại học";
            }
        } else {
            if (this.job == null){
                this.degree = Degree.SELECTWORK;
            } else {
                this.degree = Degree.WORK;
            }
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public boolean buy(Context context, NetWorth thing){
        return bank.decrease(context, thing.price);
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

    public boolean doLeisure(Context context, Leisure leisure){
        if(bank.decrease(context, leisure.getFee())){
            condition.effect(leisure.getEffect());
            return true;
        }
        return false;
    }

    public  boolean useCure(Context context, Cure cure) {
        if(bank.decrease(context, cure.getFee())){
            condition.effect(cure.getEffect());
            return true;
        }
        return false;
    }

    public void setJob(Job job){
       this.job = job;

    }

    public void  setUniversity(University university){
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public Job getJob() {
        return job;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getStrDegree() {
        return strDegree;
    }
}
