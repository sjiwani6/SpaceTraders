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

    /**
     * this is the constructor for the class.
     * @param resources passes in the resources.
     */
    Resources(String resources) {
        this.resources = resources;
    }

    /**
     * this is the getter for the resources.
     * @return the resource.
     */
    public String getResources() {
        return resources;
    }

    /**
     * this is the toString method.
     * @return returns the resources as a string.
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
