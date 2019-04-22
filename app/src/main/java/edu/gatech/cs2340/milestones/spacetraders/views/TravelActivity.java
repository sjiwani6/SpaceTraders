package edu.gatech.cs2340.milestones.spacetraders.views;

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
    private HashMap<String, ArrayList<Integer>> tempCargo;

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
    private int diffCalc;
    private double maxCheck;

    private String[] randomEvent = {
            "Illegal Trespassing", "Ape Attacked", "Found some credits",
            "Fuel refill","Pirates Attacked", "Ship damaged by Rocks",
            "Lost a crew member", "Police Check", "Civilian's Ship under attack",
            "Engine Failed", "Stopped by Galaxy Patrol", "Unknown being found",
            "Encountered Pirate GNAT", "Found Resource: "
    };

    private Items[] items = Items.values();
//    private String[] extraRandomEvents = {"Ship damaged by Rocks",
//            "Lost a crew member", "Police Check", "Civilian's Ship under attack",
//            "Engine Failed", "Stopped by Galaxy Patrol", "Unknown being found",
//            "Encountered Pirate GNAT"
//    };

    private Dialog myDialog;

    /**
     * Layout setup
     * @param savedInstanceState configuration
     */
    @Override
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
        int tempDist = Travel.calcDistance(player.getPlayerLocation(),player.getPlayerLocation());
        distance.setText(""+ (tempDist / 3) + "parsecs");

    }

    //Change the name of the method
    /**
     * Action for travelling
     * @param view
     */
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
        final int dist = Travel.calcDistance(temp, player.getPlayerLocation());
        planetName.setText(temp.getName());
        name.setText(temp.getName());
        techLevel.setText(temp.getTechLevel().toString());
        distance.setText("" + (dist/3) + " parsecs");

        Log.d(planetList[count].getName(), "dist is :"+ dist);
        Log.d("count: ", "" + count);
        if (dist > 50 || player.getPlayerShip().getFuel() < (dist/3)) {
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
        String diff = player.getDiff();
        if (diff.equalsIgnoreCase("Easy")) {
            diffCalc = 1;
            maxCheck = 0.2;
        } else if (diff.equalsIgnoreCase("Normal")) {
            diffCalc = 2;
            maxCheck = 0.3;
        } else if (diff.equalsIgnoreCase("Hard")) {
            diffCalc = 3;
            maxCheck = 0.4;
        } else if (diff.equalsIgnoreCase("Impossible")) {
            diffCalc = 4;
            maxCheck = 0.5;
        } else {
            diffCalc = 1;
            maxCheck = 0.2;
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
                distance.setText(""+Travel.calcDistance(planetList[count],
                        player.getPlayerLocation()) + "parsecs");
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
                if ( Math.random() <= maxCheck) {
                    if (random == 0) {


                        String message = "You have been illegal trespassed and you have been " +
                                "arrested by the local police. You have to pay "+(50 * diffCalc)+"CR to get " +
                                "out of jail.";
                        eventTitle.setText("Illegal Trespassing");
                        eventMessage.setText(message);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (50 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    } else if (random == 1) {
                        String message = "Your ship has been attacked by Ape from Planet Vegeta. " +
                                "Need "+(20 * diffCalc)+"CR to repair the ship";
                        eventMessage.setText(message);
                        eventTitle.setText("Ape Attacked");
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (20*diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    } else if (random == 2) {
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
                    } else if (random == 3) {
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
                    } else if (random == 4) {

                        String message = "Pirates attacked your ship " +
                                "and stole " +(25 * diffCalc)+"CR from your vault";

                        eventMessage.setText(message);
                        eventTitle.setText("Pirates Attacked");
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (25 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();

                            }
                        });
                        myDialog.show();
                    } else if (random == 5) {
                        String message = "Your GNAT has been damaged by the space rocks and" +
                                "need "+(30 * diffCalc)+"CR to repair the ship before it become unable " +
                                "to travel to your destination.";
                        eventMessage.setText(message);
                        eventTitle.setText(randomEvent[5]);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (30 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 6) {
                        String message = "one of your crew member got sick and down during the " +
                                "travel and you need to hire upon arrival to your final " +
                                "destination. Its going to cost your "+(50 * diffCalc)+"CR to hire a crew mem";
                        eventMessage.setText(message);
                        eventTitle.setText(randomEvent[6]);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (50 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 7) {
                        ArrayList<Integer> tempNorc = new ArrayList<>();
                        tempNorc = player.getCargo().get(items[8].toString());

                        if (tempNorc.get(0) > 0) {
                            String message = "You have to been arrested for possessing illegal" +
                                    " drug in your ship and you have to pay "+(20 * diffCalc)+"CR and" +
                                    " police took all of your narcotics";
                            eventMessage.setText(message);
                            eventTitle.setText(randomEvent[7]);

                            tempCargo = player.getCargo();
                            tempNorc = tempCargo.get(items[8].toString());
                            tempNorc.add(0,0);
                            tempCargo.put(items[8].toString(),tempNorc);
                            player.setCargo(tempCargo);

                            btw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    int tempCredit = player.getCredit() - (20 * diffCalc);
                                    player.setCredit(tempCredit);
                                    myDialog.dismiss();
                                }
                            });
                        } else {
                            String message = "Police didn't find any illegal possessions so" +
                                    " they let you go without any fine";
                            eventMessage.setText(message);
                            eventTitle.setText(randomEvent[7]);
                            btw.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    myDialog.dismiss();
                                }
                            });
                        }
                    } else if (random == 8) {
                        eventTitle.setText(randomEvent[8]);
                        String message = "Our ship is under attack and if you save us " +
                                "from thr danger, we will give you "+(100 * diffCalc)+"CR";
                        eventMessage.setText(message);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() + (100 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 9) {
                        eventTitle.setText(randomEvent[9]);
                        String message = "Captain, ship'e engine failed and we need "+(50 * diffCalc)+"Cr " +
                                "for the engine part to repair the ship";
                        eventMessage.setText(message);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (50 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 10) {
                        eventTitle.setText(randomEvent[10]);
                        String message = "Captain, galaxy patrol stopped and they found out " +
                                "that we have two non-registered crew members in the ship and " +
                                "they are demanding use to pay "+(80 * diffCalc)+"CR to get register or " +
                                "they will arrest both of the crew members";
                        eventMessage.setText(message);
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (80 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 11) {
                        eventTitle.setText(randomEvent[11]);
                        String message = "Captain we found an unknown being on space and " +
                                "it's offering us foods and "+(75 * diffCalc)+"CR to save it";
                        eventMessage.setText(message);

                        ArrayList<Integer> tempFood = new ArrayList<>();
                        //tempFood = player.getCargo().get(items[2].toString());
                        tempCargo = player.getCargo();
                        tempFood = tempCargo.get(items[2].toString());
                        int numOfFood = tempFood.get(0) + 2;
                        tempFood.add(0,numOfFood);
                        tempCargo.put(items[2].toString(),tempFood);
                        player.setCargo(tempCargo);

                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() + (75 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 12) {
                        eventTitle.setText(randomEvent[8]);
                        String message = "Pirate ship attacked you and stole "+(60 * diffCalc)+"CR and some of " +
                                "resources and please check the resource to restock " +
                                "once you reach your destination";
                        eventMessage.setText(message);

                        ArrayList<Integer> tempFood = new ArrayList<>();
                        //tempFood = player.getCargo().get(items[2].toString());
                        tempCargo = player.getCargo();
                        tempFood = tempCargo.get(items[2].toString());
                        int numOfFood = tempFood.get(0);
                        if (numOfFood > 2) {
                            numOfFood = numOfFood - 2;
                        }
                        tempFood.add(0,numOfFood);
                        tempCargo.put(items[2].toString(),tempFood);
                        player.setCargo(tempCargo);

                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int tempCredit = player.getCredit() - (60 * diffCalc);
                                player.setCredit(tempCredit);
                                myDialog.dismiss();
                            }
                        });
                    } else if (random == 13) {
                        ArrayList<Integer> tempFood = new ArrayList<>();
                        tempCargo = player.getCargo();
                        int randomItem = (int) Math.random() * 9;
                        tempFood = tempCargo.get(items[randomItem].toString());
                        int numOfFood = tempFood.get(0) + 2;
                        tempFood.add(0,numOfFood);
                        tempCargo.put(items[randomItem].toString(),tempFood);
                        player.setCargo(tempCargo);


                        String message = "You found a 2 Boxes of " + tempCargo.get(items[randomItem].toString()).toString();
                        eventMessage.setText(message);
                        eventTitle.setText("Found Resource: " + tempCargo.get(items[randomItem].toString()).toString());
                        btw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                myDialog.dismiss();

                            }
                        });
                    }
                }
            }
        });
        count++;
        if (count == 9) {
            count = 0;
        }
    }

    /**
     * Returning to travel start
     * @param view
     */
    public void onBackPressed(View view) {
        closeWindow = findViewById(R.id.back_button);
        Intent myIntent2 = new Intent(TravelActivity.this, StartGameActivity.class);
        startActivity(myIntent2);
    }

    /**
     * Action for warp
     * @param view
     */
    public void onWarpPressed(View view) {
        player = viewModel.getPlayer();

    }

    public void onPressed2Dmap(View view){
        Dialog mapDialog = new Dialog(TravelActivity.this);
        mapDialog.setContentView(R.layout.universe_2d_map);
        //closeWindow = findViewById(R.id.OKMapButton);

    }
}
