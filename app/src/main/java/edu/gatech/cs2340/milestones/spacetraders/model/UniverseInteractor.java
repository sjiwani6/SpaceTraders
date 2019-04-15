package edu.gatech.cs2340.milestones.spacetraders.model;


import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

public class UniverseInteractor extends Interactor {
    public UniverseInteractor(Repository repo) {
        super(repo);
    }
    public Universe getUniverse() {
        return getRepository().getUniverse();
    }
    public void  addUniverse(Universe universe) {
        getRepository().setUniverse(universe);
    }

}
