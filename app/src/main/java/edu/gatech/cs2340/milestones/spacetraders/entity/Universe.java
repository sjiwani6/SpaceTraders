package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum Universe {
    BOBERT("Bobert"),
    NAMEK("Namek"),
    SECTOR10("Sector10"),
    CATOPIA("Catopia"),
    PLANET_VEGETA ("Planet Vegeta"),
    TONALD_DRUMP ("Tonald Drump"),
    AMITA("Amita"),
    NINEBALL("Nine Ball"),
    ARAHAS("Ahrahas"),
    SILVA("Silva");


    private String universeName;


    Universe(String universeName){
        this.universeName = universeName;
    }

    public String getUniverse() {
        return universeName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


