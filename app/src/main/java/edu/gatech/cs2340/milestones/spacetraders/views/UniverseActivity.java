package edu.gatech.cs2340.milestones.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Items;
import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Ship;
import edu.gatech.cs2340.milestones.spacetraders.model.Market;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.UniverseViewModel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class UniverseActivity extends AppCompatActivity {

    private Items item;
    private UniverseViewModel universeViewModel;

    private ConfigurationViewModel viewModel;
    private HashMap<Items, Integer> purchaseTable;
    private Player player;


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

    private TextView totalField;
    private TextView totalPrice;
    private TextView remaining;

    /**
     * Layout setup
     * @param savedInstanceState configuration
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
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

        totalField = findViewById(R.id.display_capacity);
        totalPrice = findViewById(R.id.display_total);
        remaining = findViewById(R.id.credit_count);

        View view = findViewById(R.id.buy_layout);
        view.setVisibility(View.VISIBLE);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);

        //Universe universe = universeViewModel.getUniverse();
        player = viewModel.getPlayer();
        Ship ship = player.getPlayerShip();
        //HashMap<Items, int[]> cargo = ship.getCargo();
        Planet planet = player.getPlayerLocation();
        HashMap<String, ArrayList<Integer>> planetCargo = planet.getCargo();
        Log.d("planet cargo", planet.cargoString());

        waterField.setText("0/"+ planetCargo.get(Items.WATER.getName()).get(0));
        fursField.setText("0/"+ planetCargo.get(Items.FURS.getName()).get(0));
        foodField.setText("0/"+ planetCargo.get(Items.FOOD.getName()).get(0));
        oreField.setText("0/"+ planetCargo.get(Items.ORE.getName()).get(0));
        gameField.setText("0/"+ planetCargo.get(Items.GAMES.getName()).get(0));
        fireField.setText("0/"+ planetCargo.get(Items.FIREARMS.getName()).get(0));
        medField.setText("0/"+ planetCargo.get(Items.MEDICINE.getName()).get(0));
        machField.setText("0/"+ planetCargo.get(Items.MACHINES.getName()).get(0));
        narcField.setText("0/"+ planetCargo.get(Items.NARCOTICS.getName()).get(0));
        roboField.setText("0/"+ planetCargo.get(Items.ROBOTS.getName()).get(0));

        totalField.setText("0/"+ ship.getShipType().getCapacity());
        totalPrice.setText("0Cr");
        remaining.setText(""+player.getCredit());

        purchaseTable = new HashMap<>();


    }

    /**
     * Action for buying
     * @param view is the view parameter.
     */
    public void onBuyPressed(View view) {
        View sellView = findViewById(R.id.sell_layout);
        sellView.setVisibility(View.GONE);
        View buyView = findViewById(R.id.buy_layout);
        buyView.setVisibility(View.VISIBLE);

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


        String total = totalField.getText().toString().substring(
                0, totalField.getText().toString().indexOf("/"));
        totalField = findViewById(R.id.display_capacity);
        totalPrice = findViewById(R.id.display_total);
        remaining = findViewById(R.id.credit_count);

        Planet planet = player.getPlayerLocation();
        HashMap<String, ArrayList<Integer>> planetCargo = planet.getCargo();
        Ship ship = player.getPlayerShip();

        waterField.setText("0/"+ planetCargo.get(Items.WATER.getName()).get(0));
        fursField.setText("0/"+ planetCargo.get(Items.FURS.getName()).get(0));
        foodField.setText("0/"+ planetCargo.get(Items.FOOD.getName()).get(0));
        oreField.setText("0/"+ planetCargo.get(Items.ORE.getName()).get(0));
        gameField.setText("0/"+ planetCargo.get(Items.GAMES.getName()).get(0));
        fireField.setText("0/"+ planetCargo.get(Items.FIREARMS.getName()).get(0));
        medField.setText("0/"+ planetCargo.get(Items.MEDICINE.getName()).get(0));
        machField.setText("0/"+ planetCargo.get(Items.MACHINES.getName()).get(0));
        narcField.setText("0/"+ planetCargo.get(Items.NARCOTICS.getName()).get(0));
        roboField.setText("0/"+ planetCargo.get(Items.ROBOTS.getName()).get(0));


        totalField.setText(total + "/"+ ship.getShipType().getCapacity());
        totalPrice.setText("0Cr");
        remaining.setText(""+player.getCredit());
    }

    /**
     * Action for selling
     * @param view
     */
    public void onSellPressed(View view) {

        View buyView = findViewById(R.id.buy_layout);
        buyView.setVisibility(View.GONE);
        View sellView = findViewById(R.id.sell_layout);
        sellView.setVisibility(View.VISIBLE);


        waterField = findViewById(R.id.water_count2);
        fursField = findViewById(R.id.furs_count2);
        foodField = findViewById(R.id.food_count2);
        oreField = findViewById(R.id.ore_count2);
        gameField = findViewById(R.id.game_count2);
        fireField = findViewById(R.id.fire_count2);
        medField = findViewById(R.id.med_count2);
        machField = findViewById(R.id.mach_count2);
        narcField = findViewById(R.id.narc_count2);
        roboField = findViewById(R.id.robo_count2);
        String total = totalField.getText().toString()
            .substring(0, totalField.getText().toString().indexOf("/"));
        totalField = findViewById(R.id.display_capacity2);
        totalPrice = findViewById(R.id.display_total2);
        remaining = findViewById(R.id.credit_count2);


        HashMap<String, ArrayList<Integer>> playerCargo = player.getCargo();
        Ship ship = player.getPlayerShip();

        waterField.setText("0/"+ playerCargo.get(Items.WATER.getName()).get(0));
        fursField.setText("0/"+ playerCargo.get(Items.FURS.getName()).get(0));
        foodField.setText("0/"+ playerCargo.get(Items.FOOD.getName()).get(0));
        oreField.setText("0/"+ playerCargo.get(Items.ORE.getName()).get(0));
        gameField.setText("0/"+ playerCargo.get(Items.GAMES.getName()).get(0));
        fireField.setText("0/"+ playerCargo.get(Items.FIREARMS.getName()).get(0));
        medField.setText("0/"+ playerCargo.get(Items.MEDICINE.getName()).get(0));
        machField.setText("0/"+ playerCargo.get(Items.MACHINES.getName()).get(0));
        narcField.setText("0/"+ playerCargo.get(Items.NARCOTICS.getName()).get(0));
        roboField.setText("0/"+ playerCargo.get(Items.ROBOTS.getName()).get(0));

        totalField.setText(total + "/"+ ship.getShipType().getCapacity());
        totalPrice.setText("0Cr");
        remaining.setText(""+player.getCredit());


//        ViewStub stub = (ViewStub) findViewById(R.id.stub);
//        stub.setLayoutResource(R.layout.content_sell);
        //View inflated = stub.inflate();

    }

    /**
     * When an item is selected
     * @param view
     */
    public void onItemButton(View view) {

        int id = view.getId();
        Planet planet = player.getPlayerLocation();

        HashMap<String, ArrayList<Integer>> planetCargo = planet.getCargo();
        Ship ship = player.getPlayerShip();

        int capacity = ship.getShipType().getCapacity();
        int totalCount = Integer.parseInt(""+totalField.getText().toString()
                .substring(0, totalField.getText().toString().indexOf("/")));

        String count;
        int totalCR = Integer.parseInt(totalPrice.getText().toString()
                .substring(0, totalPrice.getText().toString().indexOf("C")));

        int remainingCr = Integer.parseInt(remaining.getText().toString());
        int price;

        if (id == R.id.water_plus) {

            count = ""+ waterField.getText().toString().substring(
                    0,waterField.getText().toString().indexOf("/"));
            price = planetCargo.get(Items.WATER.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.WATER.getName()).get(0)
                && (remainingCr - totalCR - price) > 0) {

                waterField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.WATER.getName()).get(0));

                purchaseTable.put(Items.WATER, Integer.parseInt(count) + 1);
                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.furs_plus) {
            count = ""+ fursField.getText().toString()
                    .substring(0,fursField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.FURS.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.FURS.getName()).get(0)

                    && (remainingCr - totalCR - price) > 0) {
                fursField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.FURS.getName()).get(0));

                purchaseTable.put(Items.FURS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.food_plus) {
            count = ""+ foodField.getText().toString()
                    .substring(0,foodField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.FOOD.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.FOOD.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                foodField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.FOOD.getName()).get(0));

                purchaseTable.put(Items.FOOD, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.ore_plus) {
            count = ""+ oreField.getText().toString()
                    .substring(0,oreField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.ORE.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.ORE.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                oreField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.ORE.getName()).get(0));

                purchaseTable.put(Items.ORE, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.game_plus) {
            count = ""+ gameField.getText().toString()
                    .substring(0,gameField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.GAMES.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.GAMES.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                gameField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.GAMES.getName()).get(0));

                purchaseTable.put(Items.GAMES, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.fire_plus) {
            count = ""+ fireField.getText().toString()
                    .substring(0,fireField.getText().toString().indexOf("/"));
            price = planetCargo.get(Items.FIREARMS.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.FIREARMS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                fireField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.FIREARMS.getName()).get(0));

                purchaseTable.put(Items.FIREARMS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.med_plus) {
            count = ""+ medField.getText().toString()
                    .substring(0,medField.getText().toString().indexOf("/"));
            price = planetCargo.get(Items.MEDICINE.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.MEDICINE.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                medField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.MEDICINE.getName()).get(0));

                purchaseTable.put(Items.MEDICINE, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.mach_plus) {
            count = ""+ machField.getText().toString()
                    .substring(0,machField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.MACHINES.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.MACHINES.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                machField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.MACHINES.getName()).get(0));
                purchaseTable.put(Items.MACHINES, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.narc_plus) {
            count = ""+ narcField.getText().toString()
                    .substring(0,narcField.getText().toString().indexOf("/"));
            price = planetCargo.get(Items.NARCOTICS.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.NARCOTICS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                narcField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.NARCOTICS.getName()).get(0));
                purchaseTable.put(Items.NARCOTICS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.robo_plus) {
            count = ""+ roboField.getText().toString()
                    .substring(0,roboField.getText().toString().indexOf("/"));
            price = planetCargo.get(Items.ROBOTS.getName()).get(1);

            if (totalCount < capacity && Integer.parseInt(count) <
                    planetCargo.get(Items.ROBOTS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                roboField.setText(Integer.parseInt(count) + 1 +"/"+
                        planetCargo.get(Items.ROBOTS.getName()).get(0));

                purchaseTable.put(Items.ROBOTS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        //minus
        if (id == R.id.water_minus) {
            count = ""+ waterField.getText().toString()
                    .substring(0,waterField.getText().toString().indexOf("/"));
            price = planetCargo.get(Items.WATER.getName()).get(1);
            if (totalCount > 0 && Integer.parseInt(count) > 0) {

                waterField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.WATER.getName()).get(0));
                purchaseTable.put(Items.WATER, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.furs_minus) {
            count = ""+ fursField.getText().toString()
                    .substring(0,fursField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.FURS.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                fursField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.FURS.getName()).get(0));
                purchaseTable.put(Items.FURS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.food_minus) {
            count = ""+ foodField.getText().toString()
                    .substring(0,foodField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.FOOD.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                foodField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.FOOD.getName()).get(0));

                purchaseTable.put(Items.FOOD, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.ore_minus) {
            count = ""+ oreField.getText().toString()
                    .substring(0,oreField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.ORE.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                oreField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.ORE.getName()).get(0));

                purchaseTable.put(Items.ORE, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.game_minus) {
            count = ""+ gameField.getText().toString()
                    .substring(0,gameField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.GAMES.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                gameField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.GAMES.getName()).get(0));

                purchaseTable.put(Items.GAMES, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.fire_minus) {
            count = ""+ fireField.getText().toString()
                    .substring(0,fireField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.FIREARMS.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                fireField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.FIREARMS.getName()).get(0));

                purchaseTable.put(Items.FIREARMS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.med_minus) {
            count = ""+ medField.getText().toString()
                    .substring(0,medField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.MEDICINE.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                medField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.MEDICINE.getName()).get(0));

                purchaseTable.put(Items.MEDICINE, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.mach_minus) {
            count = ""+ machField.getText().toString()
                    .substring(0,machField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.MACHINES.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                machField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.MACHINES.getName()).get(0));

                purchaseTable.put(Items.MACHINES, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.narc_minus) {
            count = ""+ narcField.getText().toString()
                    .substring(0,narcField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.NARCOTICS.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                narcField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.NARCOTICS.getName()).get(0));

                purchaseTable.put(Items.NARCOTICS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.robo_minus) {
            count = ""+ roboField.getText().toString()
                    .substring(0,roboField.getText().toString().indexOf("/"));

            price = planetCargo.get(Items.ROBOTS.getName()).get(1);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                roboField.setText(Integer.parseInt(count) - 1 +"/"+
                        planetCargo.get(Items.ROBOTS.getName()).get(0));

                purchaseTable.put(Items.ROBOTS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }

        if (id == R.id.purchase) {
            Log.d("total credit = ", totalCR+"");
            player.setCredit(remainingCr - totalCR);

            HashMap<String, ArrayList<Integer>> playerCargo = player.getCargo();

            player.setCargo(Market.buyAction(purchaseTable, playerCargo));
            planet.setCargo(Market.buyAction2(purchaseTable, planetCargo));
            clearPurch();
            planetCargo = planet.getCargo();
            waterField.setText("0/"+ planetCargo.get(Items.WATER.getName()).get(0));
            fursField.setText("0/"+ planetCargo.get(Items.FURS.getName()).get(0));
            foodField.setText("0/"+ planetCargo.get(Items.FOOD.getName()).get(0));
            oreField.setText("0/"+ planetCargo.get(Items.ORE.getName()).get(0));
            gameField.setText("0/"+ planetCargo.get(Items.GAMES.getName()).get(0));
            fireField.setText("0/"+ planetCargo.get(Items.FIREARMS.getName()).get(0));
            medField.setText("0/"+ planetCargo.get(Items.MEDICINE.getName()).get(0));
            machField.setText("0/"+ planetCargo.get(Items.MACHINES.getName()).get(0));
            narcField.setText("0/"+ planetCargo.get(Items.NARCOTICS.getName()).get(0));
            roboField.setText("0/"+ planetCargo.get(Items.ROBOTS.getName()).get(0));
            totalPrice.setText("0Cr");
            remaining.setText(""+player.getCredit());
            viewModel.updatePlayer(player);
        }
    }

    /**
     * When item is selected
     * @param view
     */
    public void onItemButton2(View view) {

        int id = view.getId();
        Planet planet = player.getPlayerLocation();

        HashMap<String, ArrayList<Integer>> playerCargo = player.getCargo();

        Ship ship = player.getPlayerShip();

        int capacity = ship.getShipType().getCapacity();

        int totalCount = Integer.parseInt(""+totalField.getText().toString()
                .substring(0, totalField.getText().toString().indexOf("/")));

        String count;
        int totalCR = Integer.parseInt(totalPrice.getText().toString()
                .substring(0, totalPrice.getText().toString().indexOf("C")));

        int remainingCr = Integer.parseInt(remaining.getText().toString());
        int price;

        if (id == R.id.water_plus) {
            count = ""+ waterField.getText().toString()
                    .substring(0,waterField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.WATER.toString()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.WATER.toString()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                waterField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.WATER.toString()).get(0));

                purchaseTable.put(Items.WATER, Integer.parseInt(count) + 1);
                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.furs_plus) {
            count = ""+ fursField.getText().toString()
                    .substring(0,fursField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.FURS.toString()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.FURS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {
                fursField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.FURS.getName()).get(0));

                purchaseTable.put(Items.FURS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.food_plus) {
            count = ""+ foodField.getText().toString()
                    .substring(0,foodField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.FOOD.getName()).get(0);//exception here .getName() needed

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.FOOD.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                foodField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.FOOD.getName()).get(0));

                purchaseTable.put(Items.FOOD, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.ore_plus) {
            count = ""+ oreField.getText().toString()
                    .substring(0,oreField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.ORE.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.ORE.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                oreField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.ORE.getName()).get(0));
                purchaseTable.put(Items.ORE, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.game_plus) {
            count = ""+ gameField.getText().toString()
                    .substring(0,gameField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.GAMES.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.GAMES.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                gameField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.GAMES.getName()).get(0));
                purchaseTable.put(Items.GAMES, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.fire_plus) {
            count = ""+ fireField.getText().toString()
                    .substring(0,fireField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.FIREARMS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.FIREARMS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                fireField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.FIREARMS.getName()).get(0));
                purchaseTable.put(Items.FIREARMS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.med_plus) {
            count = ""+ medField.getText().toString()
                    .substring(0,medField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.MEDICINE.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.MEDICINE.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                medField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.MEDICINE.getName()).get(0));
                purchaseTable.put(Items.MEDICINE, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.mach_plus) {
            count = ""+ machField.getText().toString()
                    .substring(0,machField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.MACHINES.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.MACHINES.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                machField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.MACHINES.getName()).get(0));

                purchaseTable.put(Items.MACHINES, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.narc_plus) {
            count = ""+ narcField.getText().toString()
                    .substring(0,narcField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.NARCOTICS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.NARCOTICS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                narcField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.NARCOTICS.getName()).get(0));
                purchaseTable.put(Items.NARCOTICS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        if (id == R.id.robo_plus) {
            count = ""+ roboField.getText().toString()
                    .substring(0,roboField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.ROBOTS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) <
                    playerCargo.get(Items.ROBOTS.getName()).get(0)
                    && (remainingCr - totalCR - price) > 0) {

                roboField.setText(Integer.parseInt(count) + 1 +"/"+
                        playerCargo.get(Items.ROBOTS.getName()).get(0));

                purchaseTable.put(Items.ROBOTS, Integer.parseInt(count) + 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR + price + "Cr");
            }
        }
        //minus
        if (id == R.id.water_minus) {
            count = ""+ waterField.getText().toString()
                    .substring(0,waterField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.WATER.getName()).get(0);
            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                waterField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.WATER.getName()).get(0));

                purchaseTable.put(Items.WATER, Integer.parseInt(count) - 1);

                totalField.setText(totalCount - 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.furs_minus) {
            count = ""+ fursField.getText().toString()
                    .substring(0,fursField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.FURS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                fursField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.FURS.getName()).get(0));

                purchaseTable.put(Items.FURS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.food_minus) {
            count = ""+ foodField.getText().toString()
                    .substring(0,foodField.getText().toString().indexOf("/"));
            price = playerCargo.get(Items.FOOD.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                foodField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.FOOD.getName()).get(0));
                purchaseTable.put(Items.FOOD, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.ore_minus) {
            count = ""+ oreField.getText().toString()
                    .substring(0,oreField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.ORE.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                oreField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.ORE.getName()).get(0));
                purchaseTable.put(Items.ORE, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.game_minus) {
            count = ""+ gameField.getText().toString()
                    .substring(0,gameField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.GAMES.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                gameField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.GAMES.getName()).get(0));

                purchaseTable.put(Items.GAMES, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.fire_minus) {
            count = ""+ fireField.getText().toString()
                    .substring(0,fireField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.FIREARMS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                fireField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.FIREARMS.getName()).get(0));

                purchaseTable.put(Items.FIREARMS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.med_minus) {
            count = ""+ medField.getText().toString()
                    .substring(0,medField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.MEDICINE.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                medField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.MEDICINE.getName()).get(0));

                purchaseTable.put(Items.MEDICINE, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.mach_minus) {
            count = ""+ machField.getText().toString()
                    .substring(0,machField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.MACHINES.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                machField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.MACHINES.getName()).get(0));

                purchaseTable.put(Items.MACHINES, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.narc_minus) {
            count = ""+ narcField.getText().toString()
                    .substring(0,narcField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.NARCOTICS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                narcField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.NARCOTICS.getName()).get(0));

                purchaseTable.put(Items.NARCOTICS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }
        if (id == R.id.robo_minus) {
            count = ""+ roboField.getText().toString()
                    .substring(0,roboField.getText().toString().indexOf("/"));

            price = playerCargo.get(Items.ROBOTS.getName()).get(0);

            if (totalCount > 0 && Integer.parseInt(count) > 0) {
                roboField.setText(Integer.parseInt(count) - 1 +"/"+
                        playerCargo.get(Items.ROBOTS.getName()).get(0));

                purchaseTable.put(Items.ROBOTS, Integer.parseInt(count) - 1);

                totalField.setText(totalCount + 1 + "/"+capacity);
                totalPrice.setText(totalCR - price + "Cr");
            }
        }

        if (id == R.id.sell) {

            player.setCredit(remainingCr + totalCR);


            HashMap<String, ArrayList<Integer>> planetCargo = planet.getCargo();

            planet.setCargo(Market.buyAction(purchaseTable, planetCargo));
            player.setCargo(Market.buyAction2(purchaseTable, playerCargo));

            clearPurch();
            playerCargo = player.getCargo();
            waterField.setText("0/"+ playerCargo.get(Items.WATER.getName()).get(0));
            fursField.setText("0/"+ playerCargo.get(Items.FURS.getName()).get(0));
            foodField.setText("0/"+ playerCargo.get(Items.FOOD.getName()).get(0));
            oreField.setText("0/"+ playerCargo.get(Items.ORE.getName()).get(0));
            gameField.setText("0/"+ playerCargo.get(Items.GAMES.getName()).get(0));
            fireField.setText("0/"+ playerCargo.get(Items.FIREARMS.getName()).get(0));
            medField.setText("0/"+ playerCargo.get(Items.MEDICINE.getName()).get(0));
            machField.setText("0/"+ playerCargo.get(Items.MACHINES.getName()).get(0));
            narcField.setText("0/"+ playerCargo.get(Items.NARCOTICS.getName()).get(0));
            roboField.setText("0/"+ playerCargo.get(Items.ROBOTS.getName()).get(0));

            totalPrice.setText("0Cr");
            remaining.setText(""+player.getCredit());
        }
    }

    /**
     * Action for trading
     * @param view
     */
    public void onTradePressed(View view) {
        int id = view.getId();

    }

    /**
     * Calculating varience
     * @param var varience
     * @param basePrice base price for item
     * @return the calculated varience
     */
    private int varienceCalc(int var, int basePrice) {
        double varience;
        int coinFlip = (int) (Math.random() * 2);
        double randomVar = (Math.random() * var) / 100;
        if (coinFlip == 1) {
            varience = basePrice * -randomVar;
            return (int)varience;
        } else {
            varience = basePrice * randomVar;
            return (int)varience;
        }
    }

    /**
     * Clear purchase
     */
    private void clearPurch() {
        Items[] items = Items.values();
        for (int i = 0; i < items.length; i++) {
            purchaseTable.put(items[i], 0);
        }
    }

}
