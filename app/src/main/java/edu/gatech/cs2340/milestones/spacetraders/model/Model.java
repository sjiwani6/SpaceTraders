package edu.gatech.cs2340.milestones.spacetraders.model;

public class Model {
    // player instance
    private Player player;

    private static  Model instance = new Model();
    public static Model getInstance() { return instance; }

}
