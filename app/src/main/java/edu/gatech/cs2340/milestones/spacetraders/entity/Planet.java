package edu.gatech.cs2340.milestones.spacetraders.entity;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.model.EconomicModel;

public class Planet {
    private String name;
    private String description;
    private TechLevel techLevel;
    private Resources resources;
    private HashMap<String, ArrayList<Integer>> cargo;
    private int x;
    private int y;

    public Planet() {
        this.name = "";
        this.resources = null;
        this.techLevel = null;
        this.x = 0;
        this.y = 0;
        cargo = new HashMap<>();
        cargo.put(Items.WATER.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.FURS.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.FOOD.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.ORE.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.GAMES.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.FIREARMS.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.MEDICINE.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.MACHINES.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.NARCOTICS.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.ROBOTS.getName(), new ArrayList<Integer>(2));
    }
    public Planet(String name, Resources resources, TechLevel techLevel, int x, int y) {
        this.name = name;
        this.resources = resources;
        this.techLevel = techLevel;
        this.x = x;
        this.y = y;
        cargo = new HashMap<>();
        cargo.put(Items.WATER.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.FURS.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.FOOD.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.ORE.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.GAMES.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.FIREARMS.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.MEDICINE.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.MACHINES.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.NARCOTICS.getName(), new ArrayList<Integer>(2));
        cargo.put(Items.ROBOTS.getName(), new ArrayList<Integer>(2));
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

    public HashMap<String, ArrayList<Integer>> getCargo() {
        return cargo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCargo() {
        cargo = EconomicModel.setPlanetCargo(this);
        Log.d("got here?", cargo.toString());
    }

    public void setCargo(HashMap<String, ArrayList<Integer>> cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {

        return "Name: "+ name +" Resources: " + resources.toString() + " Tech Level: "
                + techLevel.toString() + " "+
                    techLevel.getTechLevelNum();
    }
    public String cargoString() {
        String string = "";
        for (String car : cargo.keySet()) {
            Log.d("does it work", car);
            Log.d("is it same?", Items.WATER.getName());
            string += car+":";
                string += "qt: "+ cargo.get(car).get(0) + " pr:" + cargo.get(car).get(1) + "\n";
        }
        return string;
    }
}
