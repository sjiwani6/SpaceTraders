package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.model.EconomicModel;

public class Planet {
    private String name;
    private String description;
    private TechLevel techLevel;
    private Resources resources;
    private HashMap<Items, int[]> cargo;
    private int x;
    private int y;

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

    public HashMap<Items, int[]> getCargo() {
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
    }
    /**
     * This is the setter for cargo.
     * @param cargo passes in the cargo.
     */
    public void setCargo(HashMap<Items, int[]> cargo) {
        this.cargo = cargo;
    }

    /**
     * this is the tostring that returns the name, resources,
     * and trch-level of the planet.
     * @return returns a string representation.
     */
    @Override
    public String toString() {
        return "Name: "+ name +" Resources: " + resources.toString() + " Tech Level: " + techLevel.toString() + " "+
                    techLevel.getTechLevelNum();
    }

    /**
     * this is the to-string fot the cargo.
     * @return returns the string representation of the cargo.
     */
    public String cargoString() {
        String string = "";
        for (Items car : cargo.keySet()) {
            string += car.toString()+":";
                string += "qt: "+ cargo.get(car)[0] + " pr:" + cargo.get(car)[1] + "\n";
        }
        return string;
    }
}
