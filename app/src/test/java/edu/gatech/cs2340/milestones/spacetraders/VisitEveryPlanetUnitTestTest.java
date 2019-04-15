package edu.gatech.cs2340.milestones.spacetraders;

import org.junit.Test;

import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import static org.junit.Assert.*;

public class VisitEveryPlanetUnitTestTest {

    @Test
    public void canTravelAll() {
        Universe testVerse = new Universe();
        Planet[] planets = testVerse.getUniverseMap().values().toArray(new Planet[10]);
        int size = planets.length;
        assertEquals(10, size);

    }
}