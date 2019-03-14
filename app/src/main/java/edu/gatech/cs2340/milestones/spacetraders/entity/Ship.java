package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.HashMap;

public class Ship {
    private ShipType shipType;
    private HashMap<Items, int[]> cargo;
    private int capacity;

    public Ship() {
        this(ShipType.GNAT);
    }
    public Ship(ShipType type) {
        this.shipType = type;
        this.capacity = 0;

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

    public ShipType getShipType() {
        return shipType;
    }

    public HashMap<Items, int[]> getCargo() {
        return cargo;
    }

    public boolean isFull() {
        return capacity == shipType.getCapacity();
    }
}
