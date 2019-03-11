package edu.gatech.cs2340.milestones.spacetraders.views;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class UniverseActivity extends Activity {
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

//        final RelativeLayout stubLayout = findViewById(R.id.stub_layout);
//
//        //buy and sell buttons
//        Button buyButton = findViewById(R.id.buy_button);
//        Button sellButton = findViewById(R.id.sell_button);

//        ViewStub stub = (ViewStub) findViewById(R.id.stub);
//        stub.setLayoutResource(R.layout.content_buy);
        //stub.setLayoutResource(R.layout.content_sell);
       // View inflated = stub.inflate();
        View view = findViewById(R.id.buy_layout);
        view.setVisibility(View.VISIBLE);

        //button = (Button) findViewById(R.id.UniverseButton);

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
