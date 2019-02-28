package edu.gatech.cs2340.milestones.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class UniverseActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);
        Log.d("here", "you got here_universe");

        button = (Button) findViewById(R.id.UniverseButton);

    }
    public void onPressed(View view) {
        Universe universe = new Universe();
        Log.d("universe", universe.toString());
    }

}
