package edu.gatech.cs2340.milestones.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class UniverseActivity extends AppCompatActivity {
    private View startgame;
    private Button button;
    private Items item;
    private Universe uni = new Universe();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //startgame = getLayoutInflater().inflate(R.layout.activity_startgame, null);
        setContentView(R.layout.activity_universe);
        Log.d("here", "you got here_universe");

        button = (Button) findViewById(R.id.UniverseButton);
        String planet = "Silva";

        int currentWater = item.WATER.getBasePrice()
                + (item.WATER.getIPL() * (uni.getIntTechLevel(planet) - item.WATER.getMTLP())
                + varienceCalc(item.WATER.getVar(),item.WATER.getBasePrice()));

        int currentFurs = item.FURS.getBasePrice()
                + (item.FURS.getIPL() * (uni.getIntTechLevel(planet) - item.FURS.getMTLP())
                + varienceCalc(item.FURS.getVar(),item.FURS.getBasePrice()));

        int currentFood = item.FOOD.getBasePrice()
                + (item.FOOD.getIPL() * (uni.getIntTechLevel(planet) - item.FOOD.getMTLP())
                + varienceCalc(item.WATER.getVar(),item.WATER.getBasePrice()));

        int currentOre = item.ORE.getBasePrice()
                + (item.ORE.getIPL() * (uni.getIntTechLevel(planet) - item.ORE.getMTLP())
                + varienceCalc(item.ORE.getVar(),item.ORE.getBasePrice()));

        int currentGames = item.GAMES.getBasePrice()
                + (item.GAMES.getIPL() * (uni.getIntTechLevel(planet) - item.GAMES.getMTLP())
                + varienceCalc(item.GAMES.getVar(),item.GAMES.getBasePrice()));

        int currentFirearms = item.FIREARMS.getBasePrice()
                + (item.FIREARMS.getIPL() * (uni.getIntTechLevel(planet) - item.FIREARMS.getMTLP())
                + varienceCalc(item.FIREARMS.getVar(),item.FIREARMS.getBasePrice()));

        int currentMedicine = item.MEDICINE.getBasePrice()
                + (item.MEDICINE.getIPL() * (uni.getIntTechLevel(planet) - item.MEDICINE.getMTLP())
                + varienceCalc(item.MEDICINE.getVar(),item.MEDICINE.getBasePrice()));

        int currentMachines = item.MACHINES.getBasePrice()
                + (item.MACHINES.getIPL() * (uni.getIntTechLevel(planet) - item.MACHINES.getMTLP())
                + varienceCalc(item.MACHINES.getVar(),item.MACHINES.getBasePrice()));

        int currentNarcotics = item.NARCOTICS.getBasePrice()
                + (item.NARCOTICS.getIPL() * (uni.getIntTechLevel(planet) - item.NARCOTICS.getMTLP())
                + varienceCalc(item.NARCOTICS.getVar(),item.NARCOTICS.getBasePrice()));

        int currentRobots = item.ROBOTS.getBasePrice()
                + (item.ROBOTS.getIPL() * (uni.getIntTechLevel(planet) - item.ROBOTS.getMTLP())
                + varienceCalc(item.ROBOTS.getVar(),item.ROBOTS.getBasePrice()));


    }
    public void onPressed(View view) {
        Universe universe = new Universe();
        Log.d("universe", universe.toString());
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);

        finish();
    }

    private int varienceCalc(int var, int basePrice) {
        double varience = 0;
        int coinFlip = (int)Math.random();
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
