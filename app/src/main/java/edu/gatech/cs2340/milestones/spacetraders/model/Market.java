package edu.gatech.cs2340.milestones.spacetraders.model;

import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;

public class Market {

    /**
     * Buying items updating player's cargo
     * @param purchaseTable what to purchase
     * @param playerCargo current cargo of player
     * @return newCargo: the updated cargo
     */
    public static HashMap<String, ArrayList<Integer>> buyAction(HashMap<Items
            , Integer> purchaseTable, HashMap<String, ArrayList<Integer>> playerCargo) {
        Items[] items = Items.values();
        HashMap<String, ArrayList<Integer>> newCargo = new HashMap<>();

        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                ArrayList<Integer> quantiPrice = new ArrayList<>();
                quantiPrice.add(0, purchaseTable.get(items[i])+
                        playerCargo.get(items[i].getName()).get(0));
                quantiPrice.add(1, playerCargo.get(items[i].getName()).get(1));
                newCargo.put(items[i].getName(), quantiPrice);

            } else {
                ArrayList<Integer> quantiPrice = new ArrayList<>();
                quantiPrice.add(0, playerCargo.get(items[i].getName()).get(0));
                quantiPrice.add(1, playerCargo.get(items[i].getName()).get(1));
                newCargo.put(items[i].getName(), quantiPrice);

            }
        }
        return newCargo;
    }

    /**
     * Buying items updating planet's cargo
     * @param purchaseTable what to purchase
     * @param planetCargo current cargo of planet
     * @return newCargo: the updated cargo
     */
    public static HashMap<String, ArrayList<Integer>> buyAction2(HashMap<Items,
            Integer> purchaseTable, HashMap<String, ArrayList<Integer>> planetCargo) {

        Items[] items = Items.values();
        HashMap<String, ArrayList<Integer>> newCargo = new HashMap<>();

        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                ArrayList<Integer> quantiPrice = new ArrayList<>();
                quantiPrice.add(0,planetCargo.get(items[i]
                        .getName()).get(0) - purchaseTable.get(items[i]));
                quantiPrice.add(1,planetCargo.get(items[i].getName()).get(1));
                newCargo.put(items[i].getName(), quantiPrice);
            } else {
                ArrayList<Integer> quantiPrice = new ArrayList<>();
                quantiPrice.add(0, planetCargo.get(items[i].getName()).get(0));
                quantiPrice.add(1,planetCargo.get(items[i].getName()).get(1));
                newCargo.put(items[i].getName(), quantiPrice);

            }
        }
        return newCargo;
    }

    /**
     * Selling items updating planet's cargo
     * @param purchaseTable what to sell
     * @param planetCargo current cargo of planet
     * @return newCargo: the updated cargo
     */
    public static HashMap<Items, int[]> sellAction(HashMap<Items,
            Integer> purchaseTable, HashMap<Items, int[]> planetCargo) {
        Items[] items = Items.values();
        HashMap<Items, int[]> newCargo = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                newCargo.put(items[i], new int[] {purchaseTable.get(items[i])
                        + planetCargo.get(items[i])[0], planetCargo.get(items[i])[1]});

            } else {
                newCargo.put(items[i], new int[] { planetCargo.get(items[i])[0]
                        , planetCargo.get(items[i])[1]});
            }
        }
        return newCargo;
    }

    /**
     * Selling items updating player's cargo
     * @param purchaseTable what tosell
     * @param playerCargo current cargo of player
     * @return newCargo: the updated cargo
     */
    public static HashMap<Items, int[]> sellAction2(HashMap<Items,
            Integer> purchaseTable, HashMap<Items, int[]> playerCargo) {
        Items[] items = Items.values();
        HashMap<Items, int[]> newCargo = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {

                newCargo.put(items[i], new int[] {playerCargo.get(items[i])[0] -
                        purchaseTable.get(items[i]), playerCargo.get(items[i])[1]});
            } else {
                newCargo.put(items[i], new int[] { playerCargo.get(items[i])[0],
                        playerCargo.get(items[i])[1]});

            }
        }
        return newCargo;
    }


}
