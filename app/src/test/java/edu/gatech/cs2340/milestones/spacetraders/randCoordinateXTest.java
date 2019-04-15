package edu.gatech.cs2340.milestones.spacetraders;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import static junit.framework.TestCase.assertTrue;


public class randCoordinateXTest {
    private Universe testCoord = new Universe();

    int i = 3;
    private int coord1;
    private int coord2;



    @Before
    public void setUp() throws Exception {
        coord1 = testCoord.randCoordinateX(10, 60, 2);
        coord2 = testCoord.randCoordinateX(10, 60, 3);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        coord1 = 0;
        coord2 = 0;
    }

    @Test
    public void randCoordinateXeven() {
            if (i % 2 == 0) {
                assertTrue(coord1 >= 20 && coord1 <= 80);
                System.out.println("The test passes for even coordinate.");
            }

        }
        @Test
        public void randCoordinateXodd() {
            if (i % 2 == 1){
                assertTrue(coord2 >= 20 && coord2 <= 80);
                System.out.println("The test passes for odd coordinate.");
            }
        }
    }
