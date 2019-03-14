package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.model.EconomicModel;

public class Planet {
    private String name;
    private String description;
    private TechLevel techLevel;
    private Resources resources;
    private HashMap<Items, int[]> cargo;

    public Planet(String name, Resources resources, TechLevel techLevel) {
        this.name = name;
        this.resources = resources;
        this.techLevel = techLevel;
        cargo = new HashMap<>();
        cargo.put(Items.WATER, new int[2]);
        cargo.put(Items.FURS, new int[2]);
        cargo.put(Items.FOOD, new int[2]);
        cargo.put(Items.ORE, new int[2]);
        cargo.put(Items.GAMES, new int[2]);
        cargo.put(Items.FIREARMS, new int[2]);
        cargo.put(Items.MEDICINE, new int[2]);
        cargo.put(Items.MACHINES, new int[2]);
        cargo.put(Items.NARCOTICS, new int[2]);
        cargo.put(Items.ROBOTS, new int[2]);
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

    public String getName() {
        return name;
    }

    public HashMap<Items, int[]> getCargo() {
        return cargo;
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



    public void setCargo() {
        cargo = EconomicModel.setPlanetCargo(this);
    }

    public void setCargo(HashMap<Items, int[]> cargo) {
        this.cargo = cargo;
    }
    @Override
    public String toString() {
        return "Name: "+ name +" Resources: " + resources.toString() + " Tech Level: " + techLevel.toString() + " "+
                    techLevel.getTechLevelNum();
    }
    public String cargoString() {
        String string = "";
        for (Items car : cargo.keySet()) {
            string += car.toString()+":";
                string += "qt: "+ cargo.get(car)[0] + " pr:" + cargo.get(car)[1] + "\n";
        }
        return string;
    }
}
