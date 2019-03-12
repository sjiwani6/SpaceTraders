package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.HashMap;

public class Ship {
    private ShipType shipType;
    private HashMap<Items, Integer> cargo;

    public Ship() {
        this(ShipType.GNAT);
    }
    public Ship(ShipType type) {
        this.shipType = type;
        cargo = new HashMap<>();
        cargo.put(Items.WATER, 0);
        cargo.put(Items.FURS, 0);
        cargo.put(Items.FOOD, 0);
        cargo.put(Items.ORE, 0);
        cargo.put(Items.GAMES, 0);
        cargo.put(Items.FIREARMS, 0);
        cargo.put(Items.MEDICINE, 0);
        cargo.put(Items.MACHINES, 0);
        cargo.put(Items.NARCOTICS, 0);
        cargo.put(Items.ROBOTS, 0);
    }

    public ShipType getShipType() {
        return shipType;
    }

    public HashMap<Items, Integer> getCargo() {
        return cargo;
    }
}
