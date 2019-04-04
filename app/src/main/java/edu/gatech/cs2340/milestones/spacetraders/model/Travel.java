package edu.gatech.cs2340.milestones.spacetraders.model;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
public class Travel {
    public static int calcDistance (Planet planet, Player player) {
        int x2 = planet.getX();
        int y2 = planet.getY();
        int x1 = player.getPlayerLocation().getX();
        int y1 = player.getPlayerLocation().getY();

        return (int) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
