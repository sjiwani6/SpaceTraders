package edu.gatech.cs2340.milestones.spacetraders.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import edu.gatech.cs2340.milestones.spacetraders.R;
import android.arch.lifecycle.ViewModelProviders;

import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.model.Travel;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.UniverseViewModel;


public class TravelActivity extends AppCompatActivity {

    private UniverseViewModel universeViewModel;
    private ConfigurationViewModel viewModel;
    private Player player;
    private Universe universe;
    private int count = 0;

    private TextView planetName;
    private TextView name;
    private TextView size;
    private TextView techLevel;
    private TextView government;
    private TextView distance;
    private TextView police;
    private TextView pirates;
    private TextView cost;

    private Button button;
    private Button wrap;
    private Button closeWindow;

    private String[] randomEvent = {
        "Illegal Trespassing", "Ape Attacked", "Found some credits",
            "Fuel refill","Pirates Attacked", "Found Resource: "
    };

    AlertDialog.Builder builder;
    Dialog myDialog;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);



        planetName = findViewById(R.id.planet_name);
        name = findViewById(R.id.name_content);
        size = findViewById(R.id.size_content);
        techLevel = findViewById(R.id.tech_content);
        government = findViewById(R.id.govt_content);
        distance = findViewById(R.id.dist_content);
        police = findViewById(R.id.police_content);
        pirates = findViewById(R.id.pirates_content);
        cost = findViewById(R.id.cost_content);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        universe = universeViewModel.getUniverse();
        player = viewModel.getPlayer();

        planetName.setText(player.getPlayerLocation().getName());
        name.setText(player.getPlayerLocation().getName());
        techLevel.setText(player.getPlayerLocation().getTechLevel().toString());
        int tempDist = Travel.calcDistance(player.getPlayerLocation(),player);
        distance.setText(""+ (tempDist / 3) + "parsecs");

    }
    //Change the name of the method
    public void onNext2Pressed(View view) {
        planetName = findViewById(R.id.planet_name);
        name = findViewById(R.id.name_content);
        size = findViewById(R.id.size_content);
        techLevel = findViewById(R.id.tech_content);
        government = findViewById(R.id.govt_content);
        distance = findViewById(R.id.dist_content);
        police = findViewById(R.id.police_content);
        pirates = findViewById(R.id.pirates_content);
        cost = findViewById(R.id.cost_content);
        universe = universeViewModel.getUniverse();
        player = viewModel.getPlayer();

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        universe = universeViewModel.getUniverse();
        player = viewModel.getPlayer();

        button = findViewById(R.id.next_content);
        wrap = findViewById(R.id.warp_button);

        final int tempFuel = player.getPlayerShip().getFuel();
        final int tempCredit = player.getCredit();

        final Planet[] planetList = universe.getUniverseMap().values().toArray(new Planet[10]);
        if (count == planetList.length) {
            count = 0;
        }
        final Planet temp = planetList[count];
        final int dist = Travel.calcDistance(temp, player);
        planetName.setText(temp.getName());
        name.setText(temp.getName());
        techLevel.setText(temp.getTechLevel().toString());
        distance.setText("" + (dist/3) + " parsecs");

        Log.d(planetList[count].getName(), "dist is :"+ dist);
        Log.d("count: ", "" + count);
        if (dist > 100 || player.getPlayerShip().getFuel() < (dist/3)) {
            wrap.setEnabled(false);
        } else {

            int fuel = player.getPlayerShip().getFuel();
            wrap.setEnabled(true);
            cost.setText("" + (dist/3) + " cr.");
            player.getPlayerShip().setFuel(fuel - (dist/3));
            Log.d(planetList[count].getName(), "dist : Fuel :  is :"+ fuel);
        }

//        builder = new AlertDialog.Builder(getApplicationContext());
//        builder = new AlertDialog.Builder(this);
//        builder.setTitle("Illegal Trespassing");
//        builder.setMessage("You have been illegal trespassed and you have been"
//                + " arrested by the local police. " +
//                "You have to pay 50CR to get out of jail.");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                int tempCredit = player.getCredit() - 50;
//                player.setCredit(tempCredit);
//            }
//        });
//
//        builder.show();
        myDialog = new Dialog(this);

        if (count == 9) {
            count = 0;
        }

        wrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("gets here", ": true");
                Log.d("count: ", "" + count);
                if (count == 0) {
                    count = 9;
                } else {
                    count--;
                }
                player.setPlayerLocation(planetList[count]);
                player.getPlayerShip().setFuel(tempFuel - (dist/3));
                player.setCredit(tempCredit - ((dist/3)/10));
                distance.setText(""+Travel.calcDistance(planetList[count], player) + "parsecs");
                cost.setText("0 cr.");
                count++;

                myDialog.setContentView(R.layout.popup_window);
                Random rn = new Random();
                int random = rn.nextInt(randomEvent.length);
                String event = randomEvent[random];



                TextView eventMessage;
                TextView eventTitle;
                eventTitle = myDialog.findViewById(R.id.popup_title);
                eventMessage = myDialog.findViewById(R.id.Whatthehell);
                Button btw;
                btw = myDialog.findViewById(R.id.ok_popup);
                if ( Math.random() <= 0.3) {
                    if (event.equalsIgnoreCase("Illegal Trespassing")) {


                        String message = "You have been illegal trespassed and you have been " +
                                "arrested by the local police. You have to pay 50CR to get " +
                                "out of jail.";
                        eventTitle.setText("Illegal Trespassing");
                        eventMessage.setText(message);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - 50;
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    } else if (event.equalsIgnoreCase("Ape Attacked")) {
                        String message = "Your ship has been attacked by Ape from Planet Vegeta. " +
                                "Need 20CR to repair the ship";
                        eventMessage.setText(message);
                        eventTitle.setText("Ape Attacked");
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - 20;
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    } else if (event.equalsIgnoreCase("Found some credits")) {
                        final int foundCR =  rn.nextInt(100);
                        String message = "You found "+ foundCR +"CR on this planet";
                        eventMessage.setText(message);
                        eventTitle.setText("Found some credits");
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() + foundCR;
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    } else if (event.equalsIgnoreCase("Fuel refill")) {
                        int tempFuel = 1;

                        if (player.getPlayerShip().getFuel() < player.getPlayerShip()
                                .getINITIAL_FUEL()) {
                            tempFuel = 10;
                        }
                        String message = "You found " + tempFuel +"gallon of SpaceShip's fuel ";
                        eventMessage.setText(message);
                        eventTitle.setText("Fuel refill");
                        player.getPlayerShip().setFuel(player.getPlayerShip().getFuel() + tempFuel);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                myDialog.dismiss();
                            }
                        });
                        myDialog.show();
                    } else if (event.equalsIgnoreCase("Pirates Attacked")) {

                        String message = "Pirates attacked your ship " +
                                "and stole 25CR from your vault";

                        eventMessage.setText(message);
                        eventTitle.setText("Pirates Attacked");
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - 25;
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    }
//                    else if (event.equalsIgnoreCase("Found Resource")) {
//                        String message = "You found a 2 Boxes of Food";
//                        eventMessage.setText(message);
//                        eventTitle.setText("Found Resource: ");
//                        HashMap<Items, int[]> temp = player.getCargo();
//                        int x=temp.get(Items.FOOD)[0] + 2;
//                        int[] tempArray = {x,20};
//                        temp.put(Items.FOOD, tempArray);
//                        player.setCargo(temp);
//                        btw.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                myDialog.dismiss();
//
//                            }
//                        });
//                        myDialog.show();
//                    }
                }
            }
        });
        count++;
        if (count == 9) {
            count = 0;
        }
    }
    public void onBackPressed(View view) {
        closeWindow = findViewById(R.id.back_button);
        Intent myIntent2 = new Intent(TravelActivity.this, StartGameActivity.class);
        startActivity(myIntent2);
    }
    public void onWarpPressed(View view) {
        player = viewModel.getPlayer();

    }
}
