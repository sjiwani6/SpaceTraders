package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Universe {

    private String universeName;
    private HashMap<HashMap<Integer,Integer>, Planet> universeMap;
    private HashMap<Integer, Integer> coordinate;
    private Resources[] resourceList;
    private TechLevel[] techLevelList;

    public Universe() {
        //150 x 100
        int i = 0;
        int x = 0;
        int y = 0;
        ArrayList<String> planetList = new ArrayList<>();
        planetList.add("Bobert");
        planetList.add("Namek");
        planetList.add("Sector10");
        planetList.add("Catopia");
        planetList.add("Planet Vegeta");
        planetList.add("Tonald Drump");
        planetList.add("Amita");
        planetList.add("Nine Ball");
        planetList.add("Ahrahas");
        planetList.add("Silva");
        resourceList = Resources.values();
        techLevelList = TechLevel.values();
        coordinate = new HashMap<>();
        universeMap = new HashMap<>();
        while (i < 10) {
            x = (int) (Math.random() * 150);
            y = (int) (Math.random() * 100);
            if (!coordinate.containsKey(x) || !coordinate.containsValue(y)) {
                HashMap<Integer, Integer> coor = new HashMap<>();
                coor.put(x, y);
                universeMap.put(coor,
                            new Planet(planetList.get(i),
                                    resourceList[(int) (Math.random() * resourceList.length)],
                                    techLevelList[(int) (Math.random()* techLevelList.length)] ));
                i++;
            }
        }
    }

    public int getIntTechLevel (String planeName){
        int currentTechLevel = 0;
        ArrayList<String> planetList = new ArrayList<>();
        planetList.add("Bobert");
        planetList.add("Namek");
        planetList.add("Sector10");
        planetList.add("Catopia");
        planetList.add("Planet Vegeta");
        planetList.add("Tonald Drump");
        planetList.add("Amita");
        planetList.add("Nine Ball");
        planetList.add("Ahrahas");
        planetList.add("Silva");
        for (int i = 0; i < 10; i++) {
            if (planeName.equals(planetList.get(i))) {
                TechLevel currTech = techLevelList[i];
                if (currTech.equals("PRE_AGRICULTURE")) {
                    currentTechLevel = 0;
                } else if (currTech.equals("AGRICULTURE")) {
                    currentTechLevel = 1;
                } else if (currTech.equals("MEDIEVAL")) {
                    currentTechLevel = 2;
                } else if (currTech.equals("RENAISSANCE")) {
                    currentTechLevel = 3;
                } else if (currTech.equals("EARLY_INDUSTRIAL")) {
                    currentTechLevel = 4;
                } else if (currTech.equals("INDUSTRIAL")) {
                    currentTechLevel = 5;
                } else if (currTech.equals("POST_INDUSTRIAL")) {
                    currentTechLevel =  6;
                } else if (currTech.equals("HI_TECH")) {
                    currentTechLevel =  7;
                }
            }
        }
        return currentTechLevel;
    }

    public String getUniverse() {
        return universeName;
    }

    @Override
    public String toString() {
        String abc = "";
        for (HashMap<Integer, Integer> coor : universeMap.keySet()) {

            for (Integer x : coor.keySet()) {
                abc = abc + "X:\t" + x;
                abc = abc + "\t Y:\t" + coor.get(x) + "\t";
            }
            abc = abc + universeMap.get(coor).toString() + "\n";
        }
        return abc;
    }
}
