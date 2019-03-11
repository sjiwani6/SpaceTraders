package edu.gatech.cs2340.milestones.spacetraders.views;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
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

import java.util.Random;

public class UniverseActivity extends AppCompatActivity {
    private Items item;
    private UniverseViewModel universeViewModel;
    private ConfigurationViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);
        Log.d("here", "you got here_universe");

        View view = findViewById(R.id.buy_layout);
        view.setVisibility(View.VISIBLE);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        Universe universe = universeViewModel.getUniverse();

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
