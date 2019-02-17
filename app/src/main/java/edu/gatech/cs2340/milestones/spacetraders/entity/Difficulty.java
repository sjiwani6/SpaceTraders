package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum Difficulty {
    EASY("Easy"),
    NORMAl("Normal"),
    HARD ("Hard");

    private final String diffLevel;

    Difficulty(String diffLevel){
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
