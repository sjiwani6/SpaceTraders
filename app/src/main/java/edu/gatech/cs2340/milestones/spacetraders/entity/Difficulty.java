package edu.gatech.cs2340.milestones.spacetraders.entity;


public enum Difficulty {
    EASY("Easy"),
    NORMAl("Normal"),
    HARD ("Hard"),
    IMPOSSIBLE ("Impossible");

    private String diffLevel;

    Difficulty(String diffLevel){
        this.diffLevel = diffLevel;
    }

    /**
     * This method is used to return the difficulty level.
     * @return returns the difficulty level.
     */
    public String getDiffLevel() {
        return diffLevel;
    }

    /**
     * This is the toString method.
     * @return a string representation of the difficulty level.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
