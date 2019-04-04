package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.HashMap;

public class Ship {
    private ShipType shipType;
    private HashMap<Items, int[]> cargo;
    private int capacity;
    private int fuel;

    public Ship() {
        this(ShipType.GNAT);
    }
    public Ship(ShipType type) {
        this.shipType = type;
        this.capacity = 0;
        this.fuel = 50;

        cargo = new HashMap<>();
        cargo.put(Items.WATER, new int[] {0,20});
        cargo.put(Items.FURS, new int[]{0,20});
        cargo.put(Items.FOOD, new int[]{0,20});
        cargo.put(Items.ORE, new int[]{0,20});
        cargo.put(Items.GAMES, new int[]{0,20});
        cargo.put(Items.FIREARMS, new int[]{0,20});
        cargo.put(Items.MEDICINE, new int[]{0,20});
        cargo.put(Items.MACHINES, new int[]{0,20});
        cargo.put(Items.NARCOTICS, new int[]{0,20});
        cargo.put(Items.ROBOTS, new int[]{0,20});
    }

    public void setCargo(HashMap<Items, int[]> cargo) {
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

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public HashMap<Items, int[]> getCargo() {
        return cargo;
    }

    public boolean isFull() {
        return capacity == shipType.getCapacity();
    }
}
