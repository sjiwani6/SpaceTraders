package edu.gatech.cs2340.milestones.spacetraders.model;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

public class Travel {
    /**
     * Calculates the distance between the player's current position and the planet
     * @param planet1 the destination
     * @param planet2 the source
     * @return distance between source and destination
     */
    public static int calcDistance (Planet planet1, Planet planet2) {
        int x2 = planet1.getX();
        int y2 = planet1.getY();
        int x1 = planet2.getX();
        int y1 = planet2.getY();

        return (int) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
