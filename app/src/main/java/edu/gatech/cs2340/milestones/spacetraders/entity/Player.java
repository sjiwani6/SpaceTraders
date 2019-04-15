package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Player {

    private String name;
    //points
    private int pilotPoint;
    private int engineerPoint;
    private int tradePoint;
    private int fighterPoint;
    private int credit;
    private final int INITIAL_CREDIT = 1000;
    private int skillPoint;
    private final int INITIAL_SKILL = 20;
    //
    private Ship playerShip;
    private Planet playerLocation;


    public Player(){
        this("Bob Waters");
    }
    public Player(String name) {
        this.name = name;
        skillPoint = INITIAL_SKILL;
        credit = INITIAL_CREDIT;
        pilotPoint = 1;
        engineerPoint = 1;
        tradePoint = 1;
        fighterPoint = 1;
        skillPoint -= 4;
        playerShip = new Ship();
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

    public Ship getPlayerShip() {
        return playerShip;
    }

    public void setPlayerShip(Ship playerShip) {
        this.playerShip = playerShip;
    }

    public Planet getPlayerLocation() {
        return playerLocation;
    }

    public HashMap<String, ArrayList<Integer>> getCargo() {
        return playerShip.getCargo();
    }

    public void setCargo(HashMap<String, ArrayList<Integer>> cargo) {
        playerShip.setCargo(cargo);
    }

    public void setPlayerLocation(Planet playerLocation) {
        this.playerLocation = playerLocation;
    }

    @Override
    public String toString() {
        return "Player: "+name+", Pilot Points: "+pilotPoint+", Engineer " +
                "Points: "+engineerPoint+", Trade Points: "+tradePoint+", Fighter  Points: "
                +fighterPoint+", Credit: "+credit+", Location: "+playerLocation.getName();
    }
}
