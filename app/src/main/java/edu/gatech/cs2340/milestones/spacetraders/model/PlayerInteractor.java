package edu.gatech.cs2340.milestones.spacetraders.model;

import android.util.Log;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

public class PlayerInteractor extends Interactor {

    public PlayerInteractor(Repository repo) {
        super(repo);
    }

    public Player getPlayer() {
        return getRepository().getPlayer();
    }

    public void  addPlayer(Player player) {
        getRepository().setPlayer(player);
    }
    public void updatePlayer(Player player) {
        getRepository().updatePlayer(player);
        Log.d("APP", "Interactor: updating player: " + player);

    }
}
