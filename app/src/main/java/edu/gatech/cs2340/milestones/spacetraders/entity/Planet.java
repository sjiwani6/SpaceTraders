package edu.gatech.cs2340.milestones.spacetraders.entity;

public class Planet {
    private String name;
    private String description;
    private TechLevel techLevel;
    private Resources resources;

    public Planet(String name, Resources resources, TechLevel techLevel) {
        this.name = name;
        this.resources = resources;
        this.techLevel = techLevel;
    }

    //getters
    public String getDescription() {
        return description;
    }

    public Resources getResources() {
        return resources;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    @Override
    public String toString() {
        return "Name: "+ name +" Resources: " + resources.toString() + " Tech Level: " + techLevel.toString();
    }
}
