package edu.gatech.cs2340.milestones.spacetraders.entity;

public class Planet {

    private String description;
    private TechLevel techLevel;
    private Resources resources;

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
}
