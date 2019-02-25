package edu.gatech.cs2340.milestones.spacetraders.entity;

enum Resources {
    NOSPECIALRESOURCES("No Special Resources"),
    MINERALRICH("Mineral Rich"),
    MINERALPOOR("Mineral Poor"),
    DESERT("Desert") ,
    LOTSOFWATER("Lots of Water"),
    RICHSOIL("Rich Soil"),
    POORSOIL("Poor Soil"),
    RICHFAUNA("Rich Fauna"),
    LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird Mushrooms"),
    LOTSOFHERBS("Lots of Water"),
    ARTISTIC("Lots of Herbs"),
    WARLIKE("Warlike");

    private String resources;

    Resources(String techLevel) {
        this.resources = techLevel;
    }

    public String getTechLevel() {
        return resources;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
