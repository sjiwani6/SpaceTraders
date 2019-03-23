package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum ShipType {
    GNAT ("Gnat", 15);

    private final String shipType;
    private int capacity;

    ShipType(String shipType, int capacity){
        this.shipType = shipType;
        this.capacity = capacity;
    }

    public String getShipType() {
        return shipType;
    }
    public int getCapacity() {
        return capacity;
    }
}
