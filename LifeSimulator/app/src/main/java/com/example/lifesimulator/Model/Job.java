package com.example.lifesimulator.Model;

public class Job {
    int resourceID;
    String name;
    String description;
    int grossSalary;

    public Job(int resourceID, String name, String description, int grossSalary) {
        this.resourceID = resourceID;
        this.name = name;
        this.description = description;
        this.grossSalary = grossSalary;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }
}
