package edu.gatech.cs2340.milestones.spacetraders.model;

import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.TechLevel;

public class EconomicModel {

    public static HashMap<Items, int[]> setPlanetCargo(Planet planet) {
        Items[] items = Items.values();
        TechLevel level = planet.getTechLevel();
        int levelNum = level.getTechLevelNum();
        HashMap<Items, int[]> cargo = planet.getCargo();
        int quantity = 0;
        int price = 0;
        for (int i = 0; i < items.length; i++) {
            if(items[i].getMTLP() <= levelNum) {
                if (items[i].getTTP() == levelNum) {
                    quantity = 35 + (int) (20 * Math.random());
                    price = items[i].getBasePrice();
                    cargo.replace(items[i], cargo.get(items[i]), new int[] {quantity, price});
                } else {
                    quantity = (int) (25 * Math.random());
                    price = 20;
                    cargo.replace(items[i], cargo.get(items[i]), new int[] {quantity, price});
                }
            }

        }
        return cargo;
    }

}
