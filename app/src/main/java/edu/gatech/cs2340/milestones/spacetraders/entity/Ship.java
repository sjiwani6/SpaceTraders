package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.HashMap;
import java.util.ArrayList;

public class Ship {

    private ShipType shipType;
    private HashMap<String, ArrayList<Integer>> cargo;
    private int capacity;
    private int fuel;
    private int INITIAL_FUEL = 500;
    /**
     * this is the constructor for the class.
     */
    public Ship() {
        this(ShipType.GNAT);
    }
    /**
     * this is also a constructor.
     * @param type passes in the type of the ship.
     */
    public Ship(ShipType type) {
        this.shipType = type;
        this.capacity = 0;
        this.fuel = 500;

        cargo = new HashMap<>();
        initialCargo();
    }

    /**
     * this method stores the initial
     * cargo the player has.
     */
    private void initialCargo() {
        Items[] items = Items.values();
        for (int i = 0; i < items.length; i++) {
            ArrayList<Integer> quantiPrice = new ArrayList<>();
            quantiPrice.add(0, 0);
            quantiPrice.add(1, items[i].getBasePrice());
            cargo.put(items[i].getName(), quantiPrice);
        }
    }
    /**
     * this is the setter for cargo.
     * @param cargo passes in the cargo.
     */
    public void setCargo(HashMap<String, ArrayList<Integer>> cargo) {
        this.cargo = cargo;
    }
    /**
     * this is the getter for the shipType.
     * @return the type of the ship.
     */
    public ShipType getShipType() {
        return shipType;
    }
    /**
     * this is the getter for the capacity of the ship.
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * this is the getter for the fuel.
     * @return the fuel.
     */
    public int getFuel() {
        return fuel;
    }
    /**
     * this is the getter for initial fuel.
     * @return the initial fuel.
     */
    public int getINITIAL_FUEL() {
        return INITIAL_FUEL;
    }
    /**
     * this is the setter for the fuel.
     * @param fuel passes in the fuel.
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    /**
     * this is the setter for the capacity.
     * @param capacity passes in the capacity.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    /**
     * this is the hashmap that sti\ores the cargo.
     * @return the cargo.
     */
    public HashMap<String, ArrayList<Integer>> getCargo() {
        return cargo;
    }
    /**
     * this method checks if the fuel is full.
     * @return true if fuel is full.
     */
    public boolean isFull() {
        return capacity == shipType.getCapacity();
    }
}
