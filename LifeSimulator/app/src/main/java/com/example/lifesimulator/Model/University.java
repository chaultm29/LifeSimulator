package com.example.lifesimulator.Model;

public class University {
    int ResourceID;
    String name;
    String major;

    public University(int resourceID, String name, String major) {
        ResourceID = resourceID;
        this.name = name;
        this.major = major;
    }

    public int getResourceID() {
        return ResourceID;
    }

    public void setResourceID(int resourceID) {
        ResourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
