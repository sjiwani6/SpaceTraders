package edu.gatech.cs2340.milestones.spacetraders.entity;

public class Ship {
    private String shipName;
    private ShipType shipType;

    public Ship (String shipName) {
        this(shipName, ShipType.GNAT);
    }
    public Ship(String shipName, ShipType shipType) {
        this.shipName = shipName;
        this.shipType = shipType;
    }

    public ShipType getShipType() {
        return shipType;
    }
}
