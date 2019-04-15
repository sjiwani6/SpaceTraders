package edu.gatech.cs2340.milestones.spacetraders.model;

import android.util.Log;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

public class PlayerInteractor extends Interactor {

    /**
     * Constructor for the player interactor with a passed repository
     * @param repo the repository with the player
     */
    public PlayerInteractor(Repository repo) {
        super(repo);
    }

    /**
     * Getter for the player in the repository
     * @return the player in the repository
     */
    public Player getPlayer() {
        return getRepository().getPlayer();
    }

    /**
     * Adds player to the repository
     * @param player the player added to the repository
     */
    public void  addPlayer(Player player) {
        getRepository().setPlayer(player);
    }

    /**
     * Updates the player in the repository
     * @param player that is the updated player
     */
    public void updatePlayer(Player player) {
        getRepository().updatePlayer(player);
        Log.d("APP", "Interactor: updating player: " + player);

    }
}
