package edu.gatech.cs2340.milestones.spacetraders.model;

import java.util.HashMap;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;

public class Market {

    public static HashMap<Items, int[]> buyAction(HashMap<Items, Integer> purchaseTable, HashMap<Items, int[]> playerCargo) {
        Items[] items = Items.values();
        HashMap<Items, int[]> newCargo = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                newCargo.put(items[i], new int[] {purchaseTable.get(items[i])+ playerCargo.get(items[i])[0], playerCargo.get(items[i])[1]});
            } else {
                newCargo.put(items[i], new int[] { playerCargo.get(items[i])[0], playerCargo.get(items[i])[1]});

            }
        }
        return newCargo;
    }
    public static HashMap<Items, int[]> buyAction2(HashMap<Items, Integer> purchaseTable, HashMap<Items, int[]> planetCargo) {
        Items[] items = Items.values();
        HashMap<Items, int[]> newCargo = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                newCargo.put(items[i], new int[] {planetCargo.get(items[i])[0] - purchaseTable.get(items[i]), planetCargo.get(items[i])[1]});
            } else {
                newCargo.put(items[i], new int[] { planetCargo.get(items[i])[0], planetCargo.get(items[i])[1]});

            }
        }
        return newCargo;
    }

    public static HashMap<Items, int[]> sellAction(HashMap<Items, Integer> purchaseTable, HashMap<Items, int[]> planetCargo) {
        Items[] items = Items.values();
        HashMap<Items, int[]> newCargo = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                newCargo.put(items[i], new int[] {purchaseTable.get(items[i])+ planetCargo.get(items[i])[0], planetCargo.get(items[i])[1]});
            } else {
                newCargo.put(items[i], new int[] { planetCargo.get(items[i])[0], planetCargo.get(items[i])[1]});

            }
        }
        return newCargo;
    }
    public static HashMap<Items, int[]> sellAction2(HashMap<Items, Integer> purchaseTable, HashMap<Items, int[]> playerCargo) {
        Items[] items = Items.values();
        HashMap<Items, int[]> newCargo = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (purchaseTable.get(items[i]) != null) {
                newCargo.put(items[i], new int[] {playerCargo.get(items[i])[0] - purchaseTable.get(items[i]), playerCargo.get(items[i])[1]});
            } else {
                newCargo.put(items[i], new int[] { playerCargo.get(items[i])[0], playerCargo.get(items[i])[1]});

            }
        }
        return newCargo;
    }


}
