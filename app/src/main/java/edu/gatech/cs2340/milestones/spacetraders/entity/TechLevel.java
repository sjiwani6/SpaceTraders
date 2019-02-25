package edu.gatech.cs2340.milestones.spacetraders.entity;

enum TechLevel {
    PRE_AGRICULTURE("Pre-Agriculture"),
    AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLY_INDUSTRIAL("Renaissance"),
    POST_INDUSTRIAL("Post-Industrial"),
    HI_TECH("Hi-Tech");

    private String techLevel;

    TechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    public String getTechLevel() {
        return techLevel;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
