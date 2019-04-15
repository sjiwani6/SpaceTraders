package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum ShipType {
    GNAT ("Gnat", 15);

    private final String shipType;
    private int capacity;

    /**
     * this is the constructor for the shiptype.
     * @param shipType passes in the typoe of the ship.
     * @param capacity passes in the capacity of the ship.
     */
    ShipType(String shipType, int capacity){
        this.shipType = shipType;
        this.capacity = capacity;
    }

    /**
     * this is the getter for the shipType.
     * @return returns the shipType
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * this is the getter for capacity.
     * @return returns the capacity of the ship.
     */
    public int getCapacity() {
        return capacity;
    }
}
