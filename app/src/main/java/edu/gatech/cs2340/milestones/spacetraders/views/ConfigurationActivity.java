package edu.gatech.cs2340.milestones.spacetraders.views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Difficulty;

import edu.gatech.cs2340.milestones.spacetraders.entity.Planet;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.UniverseViewModel;

public class ConfigurationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ConfigurationViewModel viewModel;
    private UniverseViewModel universeViewModel;
    private Player player = new Player();

    private EditText nameField;
    private Spinner diffSpinner;
    private TextView pilotPoint;
    private TextView engineerPoint;
    private TextView tradePoint;
    private TextView fighterPoint;
    private TextView skillPoint;

    /**
     * Sets up the new player screen
     * @param savedInstanceState previous configuration
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Log.d("here", "you got here_configact");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }

        nameField = findViewById(R.id.name_input);
        diffSpinner = findViewById(R.id.difficuly_spinner);
        pilotPoint = findViewById(R.id.p_count);
        engineerPoint = findViewById(R.id.e_count);
        tradePoint = findViewById(R.id.t_count);
        fighterPoint = findViewById(R.id.f_count);
        skillPoint = findViewById(R.id.s_count);

        player = new Player("put your name");
        Log.d("here", player.getName());
        nameField.setText(player.getName());

        skillPoint.setText(""+player.getSkillPoint());
        pilotPoint.setText(""+player.getPilotPoint());
        engineerPoint.setText(""+player.getEngineerPoint());
        tradePoint.setText(""+player.getTradePoint());
        fighterPoint.setText(""+player.getFighterPoint());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulty1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diffSpinner.setAdapter(adapter);
        diffSpinner.setOnItemSelectedListener(this);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
    }

    /**
     * Activity for page after player screen
     * @param view
     */
    public void onNextPressed(View view) {
        if (player.getSkillPoint() == 0) {
            player.setName(nameField.getText().toString());
            player.setPilotPoint(Integer.parseInt(pilotPoint.getText().toString()));
            player.setEngineerPoint(Integer.parseInt(engineerPoint.getText().toString()));
            player.setTradePoint(Integer.parseInt(tradePoint.getText().toString()));
            player.setFighterPoint(Integer.parseInt(fighterPoint.getText().toString()));

            //universe created
            Universe universe = new Universe();
            universeViewModel.addUniverse(universe);
            Object[] planets = universe.getUniverseMap().values().toArray();
            player.setPlayerLocation((Planet) planets[(int) Math.random() * planets.length]);
            viewModel.addPlayer(player);
            Log.d("User Location: ", player.getPlayerLocation().toString());
            Log.d("user data:", player.toString());
            Log.d("universe", universe.toString());

            Intent intent = new Intent(this, StartGameActivity.class);
            startActivity(intent);
            finish();
        } else {
            String test = "Please use all of the skill points";
            Toast.makeText(getApplicationContext(), test,Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Controls skill points
     * @param view
     */
    public void onSkillButton(View view) {
        int id = view.getId();
        //
        if (id == R.id.p_plus) {
            if(player.getSkillPoint() > 0) {
                int p1 = player.getPilotPoint() + 1;
                player.setPilotPoint(p1);
                int s1 = player.getSkillPoint() - 1;
                player.setSkillPoint(s1);
                pilotPoint.setText("" + player.getPilotPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.e_plus) {
            if(player.getSkillPoint() > 0) {
                int e1 = player.getEngineerPoint() + 1;
                player.setEngineerPoint(e1);
                int s2 = player.getSkillPoint() - 1;
                player.setSkillPoint(s2);
                engineerPoint.setText("" + player.getEngineerPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.t_plus) {
            if(player.getSkillPoint() > 0) {
                int t1 = player.getTradePoint() + 1;
                player.setTradePoint(t1);
                int s3 = player.getSkillPoint() - 1;
                player.setSkillPoint(s3);
                tradePoint.setText("" + player.getTradePoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.f_plus) {
            if(player.getSkillPoint() > 0) {
                int f1 = player.getFighterPoint() + 1;
                player.setFighterPoint(f1);
                int s4 = player.getSkillPoint() - 1;
                player.setSkillPoint(s4);
                fighterPoint.setText("" + player.getFighterPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        //minus
        if (id == R.id.p_minus) {
            if (player.getPilotPoint() > 1) {
                int p2 = player.getPilotPoint() - 1;
                player.setPilotPoint(p2);
                int s5 = player.getSkillPoint() + 1;
                player.setSkillPoint(s5);
                pilotPoint.setText("" + player.getPilotPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.e_minus) {
            if(player.getEngineerPoint() > 1) {
                int e2 = player.getEngineerPoint() - 1;
                player.setEngineerPoint(e2);
                int s6 = player.getSkillPoint() + 1;
                player.setSkillPoint(s6);
                engineerPoint.setText("" + player.getEngineerPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.t_minus) {
            if(player.getTradePoint() > 1) {
                int t2 = player.getTradePoint() - 1;
                player.setTradePoint(t2);
                int s7 = player.getSkillPoint() + 1;
                player.setSkillPoint(s7);
                tradePoint.setText("" + player.getTradePoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
        if (id == R.id.f_minus) {
            if(player.getFighterPoint() > 1) {
                int f2 = player.getFighterPoint() - 1;
                player.setFighterPoint(f2);
                int s8 = player.getSkillPoint() + 1;
                player.setSkillPoint(s8);
                fighterPoint.setText("" + player.getFighterPoint());
                skillPoint.setText("" + player.getSkillPoint());
            }
        }
    }

    /**
     * Activity for selecting items
     * @param parent
     * @param view
     * @param position of item
     * @param id of item
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * When nothing is selected
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
