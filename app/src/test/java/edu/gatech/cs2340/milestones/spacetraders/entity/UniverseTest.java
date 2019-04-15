package edu.gatech.cs2340.milestones.spacetraders.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniverseTest {

    private Universe testCoordinate  = new Universe();
    private int coordinateY1;
    private int coordinateY2;
    private int coordinateY3;
    private int coordinateY4;
    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
        try {
            coordinateY1 = testCoordinate.randCoordinateY(20,60,1);
            coordinateY2 = testCoordinate.randCoordinateY(20,60,2);
            coordinateY3 = testCoordinate.randCoordinateY(20,60,3);
            coordinateY4 = testCoordinate.randCoordinateY(20,60,4);
        } catch (Exception e) {
            System.out.println("Setup failed");
        }
    }



    @Test
    public void randCoordinateYEvenPlanet() {
        int i = 1;
        while (i <= 10) {
            if (i % 2 == 0) {
                assertTrue("coordinateY1 is out of range ",coordinateY1 >= 20 && coordinateY1 <= 80);
            }
            i++;
        }
    }
    @Test
    public void randCoordinateYOddPlanet() {
        int i = 1;
        while (i <= 10) {
            if (i % 2 == 1) {
                assertTrue("coordinateY2 is out of range ", coordinateY2 >= 20 && coordinateY2 <= 80);
            }
            i++;
        }
    }

    @Test
    public void randCoordinateYOutOfRange() {
        int i = 1;
        while (i <= 10) {
            coordinateY3 = testCoordinate.randCoordinateY(20,60,i);
            assertTrue("coordinateY3 is out of range ", coordinateY3 <= 80 && coordinateY3 >= 20);
            i++;
        }

    }
    @Test
    public void randCoordinateYTestFalse() {
        int i = 1;
        while (i <= 10) {
            coordinateY4 = testCoordinate.randCoordinateY(81,100,i);
            assertEquals(false, coordinateY4 <=80 && coordinateY4 >= 20);
            i++;
        }

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        coordinateY1 = 0;
        coordinateY2 = 0;
        coordinateY3 = 0;
    }

}