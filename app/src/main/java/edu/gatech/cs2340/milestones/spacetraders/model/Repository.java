package edu.gatech.cs2340.milestones.spacetraders.model;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

class Repository {

    private Player player;

    public Repository() {

    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void updatePlayer(Player player) {
        player.setCredit(player.getCredit());
        player.setEngineerPoint(player.getEngineerPoint());
        player.setFighterPoint(player.getFighterPoint());
        player.setName(player.getName());
        player.setPilotPoint(player.getPilotPoint());
        player.setTradePoint(player.getTradePoint());
    }
}
