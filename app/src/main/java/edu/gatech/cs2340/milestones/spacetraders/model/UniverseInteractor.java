package edu.gatech.cs2340.milestones.spacetraders.model;


import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

public class UniverseInteractor extends Interactor {
    /**
     * Constructor for universe interactor
     * @param repo repository used for universe
     */
    public UniverseInteractor(Repository repo) {
        super(repo);
    }

    /**
     * Getter for the universe from the repository
     * @return the universe in the repository
     */
    public Universe getUniverse() {
        return getRepository().getUniverse();
    }

    /**
     * Adds the universe to the repository
     * @param universe that is added to the repository
     */
    public void  addUniverse(Universe universe) {
        getRepository().setUniverse(universe);
    }

}
