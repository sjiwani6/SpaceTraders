package edu.gatech.cs2340.milestones.spacetraders.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.app.Application;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.model.Model;
import edu.gatech.cs2340.milestones.spacetraders.model.PlayerInteractor;

public class ConfigurationViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    /**
     * this is the constructor for the class.
     * @param application is the application parameter.
     */
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    /**
     * this is the update method for the players.
     * it takes a player as a param and update
     * anything that is associated with the player.
     * @param player takes in a player as a parameter.
     */
    public void updatePlayer(Player player) {
        interactor.updatePlayer(player);
    }

    /**
     * this is the add method to add the
     * player when they start the game.
     * @param player takes in a player as a parameter.
     */
    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }

    /**
     * this is the getter for the player.
     * @return returns the player.
     */
    public Player getPlayer() {
        return interactor.getPlayer();
    }
}
