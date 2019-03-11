package edu.gatech.cs2340.milestones.spacetraders.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.app.Application;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.model.Model;
import edu.gatech.cs2340.milestones.spacetraders.model.PlayerInteractor;

public class ConfigurationViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }
    public void updatePlayer(Player player) {
        interactor.updatePlayer(player);
    }
    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }

    public Player getPlayer() {
        return interactor.getPlayer();
    }
}
