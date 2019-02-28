package edu.gatech.cs2340.milestones.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.milestones.spacetraders.R;

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
        setContentView(R.layout.activity_configuration);
        Log.d("here", "you got here_universe");

       // button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    public int xCoordinate(){
        Random randX = new Random();
        int rangeX = 101;
        int x = randX.nextInt(rangeX);
        return x;
    }
    public int yCoordinate(){
        Random randY = new Random();
        int rangeY = 151;
        int y = randY.nextInt(rangeY);
        return y;
    }

}