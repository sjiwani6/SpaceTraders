package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum ShipType {
    GNAT ("Gnat");

    private final String shipType;

    ShipType(String shipType){
        this.shipType = shipType;
    }

    public String getShipType() {
        return shipType;
    }
}
