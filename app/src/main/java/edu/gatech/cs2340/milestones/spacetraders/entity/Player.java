package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.ArrayList;
import java.util.HashMap;

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
    private String diff;
    private Ship playerShip;
    private Planet playerLocation;

    /**
     * this is a reference/constructor method to the player.
     */
    public Player(){
        this("Bob Waters");
    }
    /**
     * This method/constructor assigns all the skill points to the player.
     * @param name passes in the name of the player.
     */
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
        diff = Difficulty.EASY.toString();
    }

    /**
     * this is the getter for the credit.
     * @return returns the credit the player has.
     */
    public int getCredit() {
        return credit;
    }

    /**
     * this is the setter for credit.
     * @param credit passes in the credit.
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }
    /**
     * this is the getter for the engineer points.
     * @return returns the engineer points the player has.
     */
    public int getEngineerPoint() {
        return engineerPoint;
    }
    /**
     * this is the setter for engineer points.
     * @param engineerPoint passes in the engineer point.
     */
    public void setEngineerPoint(int engineerPoint) {
        this.engineerPoint = engineerPoint;
    }
    /**
     * this is the getter for the fighter point.
     * @return returns the fighter point the player has.
     */
    public int getFighterPoint() {
        return fighterPoint;
    }
    /**
     * this is the setter for fighter point.
     * @param fighterPoint passes in the fighter point.
     */
    public void setFighterPoint(int fighterPoint) {
        this.fighterPoint = fighterPoint;
    }
    /**
     * this is the getter for the pilot point.
     * @return returns the pilot point the player has.
     */
    public int getPilotPoint() {
        return pilotPoint;
    }
    /**
     * this is the setter for pilot points.
     * @param pilotPoint passes in the pilot points.
     */
    public void setPilotPoint(int pilotPoint) {
        this.pilotPoint = pilotPoint;
    }
    /**
     * this is the getter for the trade points.
     * @return returns the trade point the player has.
     */
    public int getTradePoint() {
        return tradePoint;
    }
    /**
     * this is the setter for trade points.
     * @param tradePoint passes in the trade points.
     */
    public void setTradePoint(int tradePoint) {
        this.tradePoint = tradePoint;
    }
    /**
     * this is the getter for the name.
     * @return returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * this is the setter for name.
     * @param name passes in the name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * this is the getter for the skill point.
     * @return returns the skill Points the player has.
     */
    public int getSkillPoint() {
        return skillPoint;
    }
    /**
     * this is the setter for skill points.
     * @param skillPoint passes in the skill points.
     */
    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }
    /**
     * this is the getter for the ship.
     * @return returns the ship the player has.
     */
    public Ship getPlayerShip() {
        return playerShip;
    }
    /**
     * this is the setter for ship.
     * @param playerShip passes in the ship.
     */
    public void setPlayerShip(Ship playerShip) {
        this.playerShip = playerShip;
    }
    /**
     * this is the getter for the location of the player.
     * @return returns the location.
     */
    public Planet getPlayerLocation() {
        return playerLocation;
    }

    /**
     * this is the hashmap that stores cargo of the player
     * @return the cargo in the ship
     */
    public HashMap<String, ArrayList<Integer>> getCargo() {
        return playerShip.getCargo();
    }
    /**
     * this is the setter for cargo.
     * @param cargo passes in the cargo.
     */
    public void setCargo(HashMap<String, ArrayList<Integer>> cargo) {
        playerShip.setCargo(cargo);
    }
    /**
     * this is the setter for player location.
     * @param playerLocation passes in the player location.
     */
    public void setPlayerLocation(Planet playerLocation) {
        this.playerLocation = playerLocation;
    }

    /**
     * Get the Difficulty
     * @return return a diff string
     */
    public String getDiff() {
        return diff;
    }

    /**
     * Setter for the diff string
     * @param diff string of diff
     */
    public void setDiff(String diff) {
        this.diff = diff;
    }

    /**
     * this is the tostring method.
     * @return the player skill points as a string.
     */
    public int getCapacity() {
        return playerShip.getCapacity();
    }
    public void setCapacity(int capacity) {
        playerShip.setCapacity(capacity);
    }

    @Override
    public String toString() {
        return "Player: "+name+", Pilot Points: "+pilotPoint+", Engineer " +
                "Points: "+engineerPoint+", Trade Points: "+tradePoint+", Fighter  Points: "
                +fighterPoint+", Credit: "+credit+", Location: "+playerLocation.getName();
    }
}
