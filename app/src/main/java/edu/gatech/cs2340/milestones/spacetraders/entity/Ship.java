package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;

public class Ship {

    private ShipType shipType;
    private HashMap<String, ArrayList<Integer>> cargo;
    private int capacity;
    private int fuel;
    private int INITIAL_FUEL = 500;

    public Ship() {
        this(ShipType.GNAT);
    }
    public Ship(ShipType type) {
        this.shipType = type;
        this.capacity = 0;
        this.fuel = 500;

        cargo = new HashMap<>();
        initialCargo();
    }
    public void initialCargo() {
        Items[] items = Items.values();
        for (int i = 0; i < items.length; i++) {
            ArrayList<Integer> quantiPrice = new ArrayList<>();
            quantiPrice.add(0, 0);
            quantiPrice.add(1, items[i].getBasePrice());
            cargo.put(items[i].toString(),quantiPrice);
        }
    }
    public void setCargo(HashMap<String, ArrayList<Integer>> cargo) {
        this.cargo = cargo;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFuel() {
        return fuel;
    }

    public int getINITIAL_FUEL() {
        return INITIAL_FUEL;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public HashMap<String, ArrayList<Integer>> getCargo() {
        return cargo;
    }

    public boolean isFull() {
        return capacity == shipType.getCapacity();
    }
}
