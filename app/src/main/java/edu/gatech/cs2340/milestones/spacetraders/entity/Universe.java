package edu.gatech.cs2340.milestones.spacetraders.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Universe {

    private String universeName;
    private HashMap<String, Planet> universeMap;
    private HashMap<String, String> coordinate;

    public Universe() {
        //150 x 100
        int i = 0;
        String x = "";
        String y = "";

        ArrayList<String> planetList = new ArrayList<>();
        planetList.add("Bobert");
        planetList.add("Namek");
        planetList.add("Sector10");
        planetList.add("Catopia");
        planetList.add("Planet Vegeta");
        planetList.add("Tonald Drump");
        planetList.add("Amita");
        planetList.add("Nine Ball");
        planetList.add("Ahlo");
        planetList.add("Silva");
        Resources[] resourceList = Resources.values();
        TechLevel[] techLevelList = TechLevel.values();
        coordinate = new HashMap<>();
        universeMap = new HashMap<>();

        while (i < 10) {
            x = "" + randCoordinateX(15, 120, i);
            y = "" + randCoordinateY(20, 60, i);

            if (!coordinate.containsKey(x) || !coordinate.containsValue(y)) {
                coordinate.put(x, y);
                String coor = "("+ x + ", " + y + ")";
                Planet planet = new Planet(planetList.get(i),
                        resourceList[(int) (Math.random() * resourceList.length)],
                        techLevelList[(int) (Math.random()* techLevelList.length)], Integer.parseInt(x), Integer.parseInt(y));
                planet.setCargo();
                universeMap.put(coor, planet);
                i++;
            }
        }
    }

    public HashMap<String, Planet> getUniverseMap() {
        return universeMap;
    }

    @Override
    public String toString() {
        String abc = "";
        for (String coor : universeMap.keySet()) {

//            for (String x : coor.keySet()) {
//                abc = abc + "X:\t" + x;
//                abc = abc + "\t Y:\t" + coor.get(x) + "\t";
//            }
            abc += coor + "\t" + universeMap.get(coor).toString() + "\n";
        }
        return abc;
    }
    private int randCoordinateX(int base, int range, int i) {
        Random rand = new Random();
        int coord = rand.nextInt(range) + base;
        if (coord - 10 > 15 && coord + 10 < 135) {
            if (i % 2 == 0) {
                coord += rand.nextInt(10);
            } else {
                coord -= rand.nextInt(10);

            }
        }
        return coord;
    }
    private int randCoordinateY(int base, int range, int i) {
        Random rand = new Random();
        int coord = rand.nextInt(range) + base;
        if (coord - 10 > 20 && coord + 10 < 80) {
            if (i % 2 == 0) {
                coord += rand.nextInt(6);
            } else {
                coord -= rand.nextInt(6);
            }
        }
        return coord;
    }
}
