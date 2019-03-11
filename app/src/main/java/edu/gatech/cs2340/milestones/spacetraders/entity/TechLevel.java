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

    TechLevel(String techLevel, int techLevelNum) {
        this.techLevel = techLevel;
        this.techLevelNum = techLevelNum;
    }

    public String getTechLevel() {
        return techLevel;
    }

    public int getTechLevelNum() {
        return techLevelNum;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
