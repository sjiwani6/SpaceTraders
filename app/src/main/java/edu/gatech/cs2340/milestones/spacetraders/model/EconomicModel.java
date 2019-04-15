package edu.gatech.cs2340.milestones.spacetraders.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.TechLevel;

public class EconomicModel {

    public static HashMap<String, ArrayList<Integer>> setPlanetCargo(Planet planet) {
        Items[] items = Items.values();
        TechLevel level = planet.getTechLevel();
        int levelNum = level.getTechLevelNum();
        HashMap<String, ArrayList<Integer>> cargo = planet.getCargo();

        int quantity = 0;
        int price = 0;
        for (int i = 0; i < items.length; i++) {
            if(items[i].getMTLP() <= levelNum) {
                if (items[i].getTTP() == levelNum) {

                    quantity = 35 + (int) (20 * Math.random());
                    price = items[i].getBasePrice();
                    ArrayList<Integer> quantiPrice = new ArrayList<>();
                    quantiPrice.add(0, quantity);
                    quantiPrice.add(1, price);
                    cargo.replace(items[i].getName(), cargo.get(items[i].getName()), quantiPrice);

                } else {
                    quantity = 15 + (int) (25 * Math.random());
                    price = items[i].getBasePrice();

                    ArrayList<Integer> quantiPrice = new ArrayList<>();
                    quantiPrice.add(0, quantity);
                    quantiPrice.add(1, price);

                    cargo.replace(items[i].getName(), cargo.get(items[i].getName()), quantiPrice);
                }
            } else {
                ArrayList<Integer> quantiPrice = new ArrayList<>();
                quantiPrice.add(0, 0);
                quantiPrice.add(1, 0);
                cargo.replace(items[i].getName(), cargo.get(items[i].getName()), quantiPrice);

            }

        }
        return cargo;
    }

}
