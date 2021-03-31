package com.example.lifesimulator.Model;

enum Milestone{BIRTH, NEWAGE, RELATION, STUDY, JOB, BANK, CONDITION, DISEASE, CURE, LEISURE, DEAD}
public class LifeEvent {
    private String lifeCode;
    private Milestone milestone;
    private String content;
    private Bank effectBank;
    private Condition effectCondition;

    private int eventMoney;

    public LifeEvent() {
    }

    public LifeEvent(String lifeCode, Milestone milestone, String content, Bank effectBank, Condition effectCondition) {
        this.lifeCode = lifeCode;
        this.milestone = milestone;
        this.content = content;
        this.effectBank = effectBank;
        this.effectCondition = effectCondition;
    }

    public String getLifeCode() {
        return lifeCode;
    }

    public void setLifeCode(String lifeCode) {
        this.lifeCode = lifeCode;
    }

    public int getEventMoney() {
        return eventMoney;
    }

    public void setEventMoney(int eventMoney) {
        this.eventMoney = eventMoney;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bank getEffectBank() {
        return effectBank;
    }

    public void setEffectBank(Bank effectBank) {
        this.effectBank = effectBank;
    }

    public Condition getEffectCondition() {
        return effectCondition;
    }

    public void setEffectCondition(Condition effectCondition) {
        this.effectCondition = effectCondition;
    }
}
