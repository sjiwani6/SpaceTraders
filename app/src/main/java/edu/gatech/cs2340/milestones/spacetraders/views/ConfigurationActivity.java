package edu.gatech.cs2340.milestones.spacetraders.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity {

    private ConfigurationViewModel viewModel;

    private Player player;
    private boolean editing;

    private EditText nameField;
    private Spinner diffSpinner;
    private TextView pilotPoint;
    private TextView enginnerPoint;
    private TextView tradePoint;
    private TextView fighterPoint;
    private TextView skillPoint;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);


        nameField = findViewById(R.id.name_input);
        diffSpinner = findViewById(R.id.difficuly_spinner);
        pilotPoint = findViewById(R.id.p_count);
        enginnerPoint = findViewById(R.id.e_count);
        tradePoint = findViewById(R.id.t_count);
        fighterPoint = findViewById(R.id.f_count);
        skillPoint = findViewById(R.id.s_count);

        skillPoint.setText(player.getSkillCount());
        pilotPoint.setText(player.getPilotPoint());
        enginnerPoint.setText(player.getEngineerPoint());
        tradePoint.setText(player.getTradePoint());
        fighterPoint.setText(player.getFighterPoint());

    }
    public void onNextPressed(View view){
        player.setName(nameField.getText().toString());
        player.setPilotPoint(Integer.parseInt(pilotPoint.getText().toString()));
        player.setEngineerPoint(Integer.parseInt(enginnerPoint.getText().toString()));
        player.setTradePoint(Integer.parseInt(tradePoint.getText().toString()));
        player.setFighterPoint(Integer.parseInt(fighterPoint.getText().toString()));


    }

}
