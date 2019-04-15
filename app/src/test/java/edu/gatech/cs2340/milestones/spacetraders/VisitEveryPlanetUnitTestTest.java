package edu.gatech.cs2340.milestones.spacetraders;

import org.junit.Test;

import java.util.HashSet;

import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.model.Travel;

import static org.junit.Assert.*;

public class VisitEveryPlanetUnitTestTest {

    @Test
    public void canTravelAll() {

        Universe testVerse = new Universe();
        Planet[] planets = testVerse.getUniverseMap().values().toArray(new Planet[10]);
        int size = planets.length;
        assertEquals(10, size);

        HashSet<Planet> reachable = new HashSet<>();

        for (int i = 0; i < planets.length; i++) {
            for (int j = i + 1; j < planets.length; j++) {
                if (Travel.calcDistance(planets[i], planets[j]) <= 50) {
                    reachable.add(planets[i]);
                    reachable.add(planets[j]);
                }

            }
        }
        assertEquals(size, reachable.size());

    }

    @Test
    public void lessThanUpperBound() {

        Universe testVerse2 = new Universe();
        Planet[] planets2 = testVerse2.getUniverseMap().values().toArray(new Planet[10]);
        HashSet<Planet> mustBeEmpty = new HashSet<>();

        for (int i = 0; i < planets2.length; i++) {
            for (int j = i + 1; j < planets2.length; j++) {
                if (Travel.calcDistance(planets2[i], planets2[j]) > 150) {
                    mustBeEmpty.add(planets2[i]);
                    mustBeEmpty.add(planets2[j]);
                }

            }
        }
        assertEquals(0, mustBeEmpty.size());
    }
}