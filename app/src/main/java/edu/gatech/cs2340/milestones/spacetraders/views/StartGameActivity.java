package edu.gatech.cs2340.milestones.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;

public class StartGameActivity extends AppCompatActivity {

    private Button button;
    private ConfigurationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Universe uni = new Universe();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        TextView nameField = findViewById(R.id.name);
        TextView pilotPoint = findViewById(R.id.p_count);
        TextView enginnerPoint = findViewById(R.id.e_count);
        TextView tradePoint = findViewById(R.id.t_count);
        TextView fighterPoint = findViewById(R.id.f_count);

        Player player = viewModel.getPlayer();
        pilotPoint.setText(""+player.getPilotPoint());
        enginnerPoint.setText(""+player.getEngineerPoint());
        tradePoint.setText(""+player.getTradePoint());
        fighterPoint.setText(""+player.getFighterPoint());
    }
}
