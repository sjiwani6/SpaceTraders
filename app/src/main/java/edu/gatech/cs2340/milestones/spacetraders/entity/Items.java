package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum Items {
    WATER ("Water", 0, 0, 0,30),
    FURS("Furs",0,0,0,250),
    FOOD("Food",1,0,1,100),
    ORE("Ore", 2,2,3,350),
    GAMES("Games",3,1,6,250),
    FIREARMS("Firearms", 3,1,5,1250),
    MEDICINE("Medicine",4,1,6,650),
    MACHINES("Machines", 4,3,5,900),
    NARCOTICS("Nacotics",5,0,5,3500),
    ROBOTS("Robots", 6,4,7,5000);

    private String name;
    private int  MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;

    Items (String name, int MTLP, int MTLU, int TTP, int basePrice){
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getMTLP() {
        return MTLP;
    }

    public int getMTLU() {
        return MTLU;
    }

    public int getTTP() {
        return TTP;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

