package edu.gatech.cs2340.milestones.spacetraders.model;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

class Repository {

    private Player player;
    //for m7 convenience only using 1 universe with 10 planets
    private Universe universe;

    public Repository() {
        player = new Player();
        universe = new Universe();

    }
    public Player getPlayer() {
        return player;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
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
