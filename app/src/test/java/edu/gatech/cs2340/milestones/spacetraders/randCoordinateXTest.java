package edu.gatech.cs2340.milestones.spacetraders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import static junit.framework.TestCase.assertTrue;


public class randCoordinateXTest {
    private Universe testCoord = new Universe();
    int i = 4;
    int range = 50;
    int base = 10;
    private int coord1;
    private int coord2;
    private int coord3;
    private int coord4;


    @Before
    public void setUp() throws Exception {
        coord1 = testCoord.randCoordinateX(10, 60, 4);
        coord2 = testCoord.randCoordinateX(10,30,3);
        coord3 = testCoord.randCoordinateX(5,45,6);
        coord4 = testCoord.randCoordinateX(6,40,30);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void randCoordinateX() {
        //System.out.println(coord1);
        if (i % 2 == 0 && coord1 <= coord1 + base) {
            assertTrue(true);
            System.out.print("the test Passed");
        } else {
            assertTrue(false);
            System.out.print("the test failed");

        }
        if (i % 2 == 1 && coord1 >= coord1 - base) {
            assertTrue(true);
            System.out.print("the test Passed");
        } else {
            assertTrue(false);
            System.out.print("the test failed");

        }
    }
}