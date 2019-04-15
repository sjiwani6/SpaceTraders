package edu.gatech.cs2340.milestones.spacetraders.model;

public abstract class Interactor {

    private Repository myRepository;

    /**
     * setter for myRepository
     * @param repo
     */
    protected Interactor(Repository repo) {
        myRepository = repo;
    }

    /**
     * getter myRepository
     * @return myRepository
     */
    protected Repository getRepository() {
        return myRepository;
    }
}
