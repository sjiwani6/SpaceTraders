package edu.gatech.cs2340.milestones.spacetraders.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.TechLevel;

public class EconomicModel {

    /**
     * Setter for planet cargo
     * @param planet current planet
     * @return current cargo
     */
    public static HashMap<String, ArrayList<Integer>> setPlanetCargo(Planet planet) {
        Items[] items = Items.values();
        TechLevel level = planet.getTechLevel();
        int levelNum = level.getTechLevelNum();
        HashMap<String, ArrayList<Integer>> cargo = planet.getCargo();

        int quantity;
        int price;
        for (int i = 0; i < items.length; i++) {
            if(items[i].getMTLP() <= levelNum) {
                if (items[i].getTTP() == levelNum) {

                    quantity = 35 + (int) (20 * Math.random());
                    price = items[i].getBasePrice() + varienceCalc(items[i].getVar(), items[i].getBasePrice());
                    ArrayList<Integer> quantiPrice = new ArrayList<>();
                    quantiPrice.add(0, quantity);
                    quantiPrice.add(1, price);
                    cargo.replace(items[i].getName(), cargo.get(items[i].getName()), quantiPrice);

                } else {
                    quantity = 15 + (int) (25 * Math.random());
                    price = items[i].getBasePrice() + varienceCalc(items[i].getVar(), items[i].getBasePrice());

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

    /**
     * Calculating varience
     * @param var varience
     * @param basePrice base price for item
     * @return the calculated varience
     */
    private static int varienceCalc(int var, int basePrice) {
        double varience;
        int coinFlip = (int) (Math.random() * 2);
        double randomVar = (Math.random() * var) / 100;
        if (coinFlip == 1) {
            varience = basePrice * -randomVar;
            return (int)varience;
        } else {
            varience = basePrice * randomVar;
            return (int)varience;
        }
    }

}
