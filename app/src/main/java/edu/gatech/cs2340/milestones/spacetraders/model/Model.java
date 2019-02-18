package edu.gatech.cs2340.milestones.spacetraders.model;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

public class Model {
    // player instance
    private Player player;
    private  PlayerInteractor interactor;

    private static  Model instance = new Model();
    public static Model getInstance() { return instance;}

    public PlayerInteractor getPlayerInteractor() {
        return interactor;
    }

}
