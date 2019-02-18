package edu.gatech.cs2340.milestones.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
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
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ConfigurationViewModel viewModel;

    private Player player;
    private boolean editing;

    private EditText nameField;
    private Spinner diffSpinner;
    //private Spinner testSpinner;
    private TextView pilotPoint;
    private TextView enginnerPoint;
    private TextView tradePoint;
    private TextView fighterPoint;
    private TextView skillPoint;

    private Button p_plusb;
    private Button p_minusb;
    private Button e_plusb;
    private Button e_minusb;
    private Button t_plusb;
    private Button t_minusb;
    private Button f_plusb;
    private Button f_minusb;

    private int skillpoint = 16;

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
        enginnerPoint = findViewById(R.id.e_count);
        tradePoint = findViewById(R.id.t_count);
        fighterPoint = findViewById(R.id.f_count);
        skillPoint = findViewById(R.id.s_count);

        player = new Player("put your name");
        Log.d("here", player.getName());
        nameField.setText(player.getName());
//        skillPoint.setText(player.getSkillPoint());
//        pilotPoint.setText(player.getPilotPoint());
//        enginnerPoint.setText(player.getEngineerPoint());
//        tradePoint.setText(player.getTradePoint());
//        fighterPoint.setText(player.getFighterPoint());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulty1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diffSpinner.setAdapter(adapter);
        diffSpinner.setOnItemSelectedListener(this);

        //Buttons


            p_plusb = findViewById(R.id.p_plus);
            p_plusb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
//                    int tempvalue = Integer.parseInt(pilotPoint.toString());
//                    tempvalue++;
//                    pilotPoint.setText(tempvalue);

                    Log.i("Test", "Testing string");
                }
            });



        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }

    public void onNextPressed(View view){
        player.setName(nameField.getText().toString());
        player.setPilotPoint(Integer.parseInt(pilotPoint.getText().toString()));
        player.setEngineerPoint(Integer.parseInt(enginnerPoint.getText().toString()));
        player.setTradePoint(Integer.parseInt(tradePoint.getText().toString()));
        player.setFighterPoint(Integer.parseInt(fighterPoint.getText().toString()));

        viewModel.addPlayer(player);

        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
