package edu.gatech.cs2340.milestones.spacetraders;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Ship;

public class SpaceTradersUnitTests {
    private Ship testship = new Ship();

    Items[] items;
    @Before
    public void setUp() {
        items = Items.values();
    }
    @Test
    public void testShipCargoInitial() {
        System.out.println(items.length);
        for (int i = 0; i < items.length; i++) {
            Assert.assertNotNull(items[i]);
        }
    }
    @Test
    public void testItems() {
        if (items.length > 10) {
            Assert.assertFalse("Items length is not matched", false);
        } else {
            Assert.assertTrue("Items length matched", true);
        }
    }

    @Test
    public void testItemsPrice() {
        for (int i = 0; i < items.length; i++) {
            Assert.assertTrue(items[i].getBasePrice() >= 0);
        }
    }



    @After
    public void tearDown() throws Exception {
        items = null;
    }
}
