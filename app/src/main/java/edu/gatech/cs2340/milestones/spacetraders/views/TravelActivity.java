package edu.gatech.cs2340.milestones.spacetraders.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import edu.gatech.cs2340.milestones.spacetraders.R;
import android.arch.lifecycle.ViewModelProviders;

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
    //private String[][] listPlanet;
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

        planetName.setText(player.getPlayerLocation().toString());
        name.setText(player.getPlayerLocation().getName());
        techLevel.setText(player.getPlayerLocation().getTechLevel().toString());
        int tempDist = Travel.calcDistance(player.getPlayerLocation(),player);
        distance.setText(""+ (tempDist / 3) + "parsecs");

    }

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

        final int tempfuel = player.getPlayerShip().getFuel();
        final int tempCredit = player.getCredit();

        final Planet[] planetList = (Planet[]) universe.getUniverseMap().values().toArray();
        Planet temp = planetList[count];
        final int dist = Travel.calcDistance(temp, player);
        planetName.setText(temp.getName());
        name.setText(temp.getName());
        techLevel.setText(temp.getTechLevel().toString());
        distance.setText("" + (dist/3) + "parsecs");
        if (dist > 50) {
            wrap.setEnabled(false);
        }

        wrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setPlayerLocation(planetList[count]);
                player.getPlayerShip().setFuel(tempfuel - (dist/3));
                player.setCredit(tempCredit - ((dist/3)/10));
                planetName.setText(player.getPlayerLocation().getName());
                name.setText(player.getPlayerLocation().getName());
                techLevel.setText(player.getPlayerLocation().getTechLevel().toString());
                distance.setText(Travel.calcDistance(player.getPlayerLocation(),player));
            }
        });
        count++;
        if (count == planetList.length) {
            count = 0;
        }

//        Planet[] planetList = (Planet[]) universe.getUniverseMap().values().toArray();
//        int lengthPlanets = planetList.length;
//        listPlanet = new String[lengthPlanets][3];
//        for (int i = 0; i < lengthPlanets; i++) {
//            Planet temp = planetList[i];
//            int x = temp.getX();
//            int y = temp.getY();
//            String name = temp.getName();
//            listPlanet[i][0] = name;
//            listPlanet[i][1] = ""+x;
//            listPlanet[i][2] = ""+y;
//        }
    }
    public void onBackPressed(View view) {
        closeWindow = findViewById(R.id.back_button);
        Intent myIntent2 = new Intent(TravelActivity.this, StartGameActivity.class);
        startActivity(myIntent2);
    }
}
