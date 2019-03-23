package edu.gatech.cs2340.milestones.spacetraders.entity;

public enum Items {
    WATER ("Water", 0, 0, 0,30,3,4),
    FURS("Furs",0,0,0,250,10,10),
    FOOD("Food",1,0,1,100,5,5),
    ORE("Ore", 2,2,3,350,20,10),
    GAMES("Games",3,1,6,250,-10,5),
    FIREARMS("Firearms", 3,1,5,1250,-75,100),
    MEDICINE("Medicine",4,1,6,650,-20,10),
    MACHINES("Machines", 4,3,5,900,-30,5),
    NARCOTICS("Nacotics",5,0,5,3500,-125,150),
    ROBOTS("Robots", 6,4,7,5000,-150,100);

    private String name;
    private int  MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int Var;

    Items (String name, int MTLP, int MTLU, int TTP, int basePrice, int IPL, int Var){
        this.name = name;
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.Var = Var;
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

    public int getIPL() {
        return IPL;
    }

    public int getVar() {
        return Var;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

