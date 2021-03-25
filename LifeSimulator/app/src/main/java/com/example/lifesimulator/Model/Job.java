package com.example.lifesimulator.Model;

public class Job {
    int resourceID;
    String name;
    float grossSalary;
    int progress;

    public Job(int resourceID, String name, float grossSalary, int progress) {
        this.resourceID = resourceID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.progress = progress;
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

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
