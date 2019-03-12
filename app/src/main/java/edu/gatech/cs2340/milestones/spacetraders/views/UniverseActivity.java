package edu.gatech.cs2340.milestones.spacetraders.views;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Ship;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.UniverseViewModel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class UniverseActivity extends AppCompatActivity {
    private Items item;
    private UniverseViewModel universeViewModel;
    private ConfigurationViewModel viewModel;

    private TextView waterField;
    private TextView fursField;
    private TextView foodField;
    private TextView oreField;
    private TextView gameField;
    private TextView fireField;
    private TextView medField;
    private TextView machField;
    private TextView narcField;
    private TextView roboField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);
        Log.d("here", "you got here_universe");


        waterField = findViewById(R.id.water_count);
        fursField = findViewById(R.id.furs_count);
        foodField = findViewById(R.id.food_count);
        oreField = findViewById(R.id.ore_count);
        gameField = findViewById(R.id.game_count);
        fireField = findViewById(R.id.fire_count);
        medField = findViewById(R.id.med_count);
        machField = findViewById(R.id.mach_count);
        narcField = findViewById(R.id.narc_count);
        roboField = findViewById(R.id.robo_count);


        View view = findViewById(R.id.buy_layout);
        view.setVisibility(View.VISIBLE);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        Universe universe = universeViewModel.getUniverse();
        Player player = viewModel.getPlayer();
        Ship ship = player.getPlayerShip();
        HashMap<Items, Integer> cargo = ship.getCargo();
        Planet planet = player.getPlayerLocation();
        HashMap<Items,int[]> planetCargo = planet.getCargo();
        Log.d("planet cargo", planet.cargoString());

        waterField.setText("0/"+ planetCargo.get(Items.WATER)[0]);
        fursField.setText("0/"+ planetCargo.get(Items.FURS)[0]);
        foodField.setText("0/"+ planetCargo.get(Items.FOOD)[0]);
        oreField.setText("0/"+ planetCargo.get(Items.ORE)[0]);
        gameField.setText("0/"+ planetCargo.get(Items.GAMES)[0]);
        fireField.setText("0/"+ planetCargo.get(Items.FIREARMS)[0]);
        medField.setText("0/"+ planetCargo.get(Items.MEDICINE)[0]);
        machField.setText("0/"+ planetCargo.get(Items.MACHINES)[0]);
        narcField.setText("0/"+ planetCargo.get(Items.NARCOTICS)[0]);
        roboField.setText("0/"+ planetCargo.get(Items.ROBOTS)[0]);




    }

    public void onBuyPressed(View view) {
//        ViewStub stub = (ViewStub) findViewById(R.id.stub);
//        stub.setLayoutResource(R.layout.content_buy);
        //View inflated = stub.inflate();
        View sellView = findViewById(R.id.sell_layout);
        sellView.setVisibility(View.GONE);
        View buyView = findViewById(R.id.buy_layout);
        buyView.setVisibility(View.VISIBLE);
    }
    public void onSellPressed(View view) {

        View buyView = findViewById(R.id.buy_layout);
        buyView.setVisibility(View.GONE);
        View sellView = findViewById(R.id.sell_layout);
        sellView.setVisibility(View.VISIBLE);
//        ViewStub stub = (ViewStub) findViewById(R.id.stub);
//        stub.setLayoutResource(R.layout.content_sell);
        //View inflated = stub.inflate();

    }

    public void onItemButton(View view) {
        int id = view.getId();
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
