package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum TechLevel {
    PRE_AGRICULTURE("Pre-Agriculture", 0),
    AGRICULTURE("Agriculture", 1),
    MEDIEVAL("Medieval", 2),
    RENAISSANCE("Renaissance", 3),
    EARLY_INDUSTRIAL("Renaissance", 4),
    INDUSTRIAL("Industrial", 5),
    POST_INDUSTRIAL("Post-Industrial", 6),
    HI_TECH("Hi-Tech", 7);

    private String techLevel;
    private int techLevelNum;

    /**
     * this is the constructor for the techlevel of the planets.
     * @param techLevel passes in the string techLevel.
     * @param techLevelNum passes in the int techLevel.
     */
    TechLevel(String techLevel, int techLevelNum) {
        this.techLevel = techLevel;
        this.techLevelNum = techLevelNum;
    }

    /**
     * is the getter for the techLevel.
     * @return the techLevel
     */
    public String getTechLevel() {
        return techLevel;
    }

    /**
     * is the getter for the integer techLevel.
     * @return an int value for the techLevel.
     */
    public int getTechLevelNum() {
        return techLevelNum;
    }

    /**
     * is the toString method.
     * @return the techLevels as a string.
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
