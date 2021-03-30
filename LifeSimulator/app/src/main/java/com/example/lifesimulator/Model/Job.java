package com.example.lifesimulator.Model;

public class Job {
    int resourceID;
    String name;
    int grossSalary;

    public Job(int resourceID, String name, int grossSalary) {
        this.resourceID = resourceID;
        this.name = name;
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

    public int getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

}
