package edu.gatech.cs2340.milestones.spacetraders.entity;

import android.util.Log;

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

    /**
     * this is the constructor for the planet.
     * it creates a hashmap to store all the
     * cargo that the player has accumulated.
     */
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
    /**
     * this is the constructor for the class planet.
     * @param name this is the name of the planet that is passed in.
     * @param resources passes in the resources of the planet
     * @param techLevel passes in the tech-level of the planet.
     * @param x x-coordinate of the planet
     * @param y y-coordinate of the planet
     */
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

    /**
     * This is the getter for description.
     * @return returns the description of the planet.
     */
    public String getDescription() {
        return description;
    }
    /**
     * This is the getter for resources.
     * @return returns the resources of the planet.
     */
    public Resources getResources() {
        return resources;
    }
    /**
     * This is the getter for Tech-Level.
     * @return returns the tech-level of the planet.
     */

    public TechLevel getTechLevel() {
        return techLevel;
    }
    /**
     * This is the toString method.
     * @return returns the name of the planet.
     */
    public String getName() {
        return name;
    }
    /**
     * this is the items that is in the planet.
     * @return returns the cargo.
     */
    public HashMap<String, ArrayList<Integer>> getCargo() {
        return cargo;
    }
    /**
     * This is the getter for x-coordinate.
     * @return returns the x-coordinate of the planet.
     */
    public int getX() {
        return x;
    }
    /**
     * This is the getter for y-coordinate.
     * @return returns the y-coordinate of the planet.
     */
    public int getY() {
        return y;
    }

    /**
     * This is the setter for description.
     * @param description is the description of the planet.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * This is the setter for resources.
     * @param resources passes in the resources of the planet.
     */
    public void setResources(Resources resources) {
        this.resources = resources;
    }
    /**
     * This is the setter for TechLevel.
     * @param techLevel passes in the TechLevel of the planet.
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }
    /**
     * This is the setter for x-coordinate.
     * @param x passes in the x-coordinate of the planet.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * This is the setter for y-coordinate.
     * @param y passes in the y-coordinate of the planet.
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * This is the setter for cargo.
     \     */
    public void setCargo() {
        cargo = EconomicModel.setPlanetCargo(this);
        Log.d("got here?", cargo.toString());
    }
    /**
     * This is the setter for cargo.
     * @param cargo passes in the cargo.
     */
    public void setCargo(HashMap<String, ArrayList<Integer>> cargo) {
        this.cargo = cargo;
    }
    /**
     * this is the tostring that returns the name, resources,
     * and trch-level of the planet.
     * @return returns a string representation.
     */
    @Override
    public String toString() {

        return "Name: "+ name +" Resources: " + resources.toString() + " Tech Level: "
                + techLevel.toString() + " "+
                    techLevel.getTechLevelNum();
    }
    /**
     * this is the to-string fot the cargo.
     * @return returns the string representation of the cargo.
     */
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
