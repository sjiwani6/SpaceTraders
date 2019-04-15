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
    private int coordinateY5;
    private int coordinateY6;
    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
        try {
            coordinateY1 = testCoordinate.randCoordinateY(20,60,1);
            coordinateY2 = testCoordinate.randCoordinateY(20,60,2);
            coordinateY3 = testCoordinate.randCoordinateY(20,60,3);
            coordinateY4 = testCoordinate.randCoordinateY(20,60,4);
            coordinateY5 = testCoordinate.randCoordinateY(20,60,5);
            coordinateY6 = testCoordinate.randCoordinateY(20,60,6);
        } catch (Exception e) {
            System.out.println("Setup failed");
        }
    }



    @Test
    public void randCoordinateY() {
        assertTrue(20 <= coordinateY1 && coordinateY1 <= 60);
        assertTrue(20 <= coordinateY2 && coordinateY2 <= 60);
        assertTrue(20 <= coordinateY3 && coordinateY3 <= 60);
        assertTrue(20 <= coordinateY4 && coordinateY4 <= 60);
        assertTrue(20 <= coordinateY5 && coordinateY5 <= 60);
        assertTrue(20 <= coordinateY6 && coordinateY6 <= 60);


    }
    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        coordinateY1 = 0;
        coordinateY2 = 0;
        coordinateY3 = 0;
        coordinateY4 = 0;
        coordinateY5 = 0;
        coordinateY6 = 0;
    }

}