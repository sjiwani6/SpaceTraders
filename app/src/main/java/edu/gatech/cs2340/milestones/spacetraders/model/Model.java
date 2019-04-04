package edu.gatech.cs2340.milestones.spacetraders.model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

public class Model {
    // player instance
    private Player player;
    private  PlayerInteractor interactor;

    private Repository myRepository;
    private Map<String, Object>interactorMap;

    private static  Model instance = new Model();

    public static Model getInstance() { return instance;}

    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }
    public UniverseInteractor getUniverseInteractor() {
        return (UniverseInteractor) interactorMap.get("Universe");
    }

    private Model() {
        Log.d("model", "arrived here ");
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }
    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
        interactorMap.put("Universe", new UniverseInteractor(myRepository));
    }
}
