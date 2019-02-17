package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum levelDifficulty {
    EASY("Easy"),
    NORMAl("Normal"),
    HARD ("Hard");

    private final String diffLevel;

    levelDifficulty (String diffLevel){
        this.diffLevel = diffLevel;
    }

    public String getDiffLevel() {
        return diffLevel;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
