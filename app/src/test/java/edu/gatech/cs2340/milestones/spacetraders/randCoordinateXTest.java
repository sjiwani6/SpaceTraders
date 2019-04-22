package edu.gatech.cs2340.milestones.spacetraders;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import static junit.framework.TestCase.assertTrue;


public class randCoordinateXTest {
    private Universe testCoord = new Universe();

    int i = 1;
    private int coord1;
    private int coord2;
    private int coord3;



    @Before
    public void setUp() throws Exception {
        coord1 = testCoord.randCoordinateX(10, 60, 2);
        coord2 = testCoord.randCoordinateX(10, 60, 4);

        coord3 = testCoord.randCoordinateX(10, 90, 3);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        coord1 = 0;
        coord2 = 0;
        coord3 = 0;
    }

    @Test
    public void randCoordinateXeven() {
            if (i % 2 == 0) {
                assertTrue(coord1 >= 20 && coord1 <= 80);
                System.out.println("The test passes for even coordinate.");
            }

            if (i % 2 == 1){
                assertTrue(coord2 >= 20 && coord2 <= 80);
                System.out.println("The test passes for odd coordinate.");
            }
        coord3 = testCoord.randCoordinateY(20,80,i);
        Assert.assertTrue("coor3 is out of range ", coord3 <= 80);
        Assert.assertTrue("coord3 is out of range ", coord3 >= 20);
        }

    }
