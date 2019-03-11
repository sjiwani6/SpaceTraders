package edu.gatech.cs2340.milestones.spacetraders.entity;

public class Ship {
    private ShipType shipType;
    //private Cargo cargo;

    public Ship() {
        this(ShipType.GNAT);
    }
    public Ship(ShipType type) {
        this.shipType = type;
    }

    public ShipType getShipType() {
        return shipType;
    }

//    public Cargo getCargo() {
//        return cargo;
//    }
}
