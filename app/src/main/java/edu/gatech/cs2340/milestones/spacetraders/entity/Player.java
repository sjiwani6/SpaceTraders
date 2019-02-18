package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.Arrays;
import java.util.List;

public class Player {

    private String name;
    private int pilotPoint;
    private int engineerPoint;
    private int tradePoint;
    private int fighterPoint;
    private int credit;
    private final int INITIAL_CREDIT = 10000;
    private int skillPoint;
    private int INITIAL_SKILL = 20;

    public static List<Difficulty> difficultyList = Arrays.asList(Difficulty.EASY, Difficulty.NORMAl, Difficulty.HARD, Difficulty.IMPOSSIBLE);


    public Player(String name, int pilotPoint, int engineerPoint, int tradePoint, int fighterPoint) {
        this.name = name;
        this.pilotPoint = pilotPoint;
        this.engineerPoint = engineerPoint;
        this.tradePoint = tradePoint;
        this.fighterPoint = fighterPoint;
        this.credit = INITIAL_CREDIT;
        this.skillPoint = INITIAL_SKILL;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getEngineerPoint() {
        return engineerPoint;
    }

    public void setEngineerPoint(int engineerPoint) {
        this.engineerPoint = engineerPoint;
    }

    public int getFighterPoint() {
        return fighterPoint;
    }

    public void setFighterPoint(int fighterPoint) {
        this.fighterPoint = fighterPoint;
    }

    public int getPilotPoint() {
        return pilotPoint;
    }

    public void setPilotPoint(int pilotPoint) {
        this.pilotPoint = pilotPoint;
    }

    public int getTradePoint() {
        return tradePoint;
    }

    public void setTradePoint(int tradePoint) {
        this.tradePoint = tradePoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSkillPoint() {
        return skillPoint;
    }
    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    @Override
    public String toString() {
        return String.format("Player: %s, Pilot Points: %d, Engineer " +
                "Points: %d, Trade Points: %d, Fighter  Points: %d, Credit: %d", name,
                pilotPoint, engineerPoint,tradePoint,fighterPoint,credit);
    }
}
