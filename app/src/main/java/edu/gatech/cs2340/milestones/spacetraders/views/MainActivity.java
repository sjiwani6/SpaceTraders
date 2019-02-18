package edu.gatech.cs2340.milestones.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.milestones.spacetraders.R;

public class MainActivity extends AppCompatActivity {

    private View configView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        configView = getLayoutInflater().inflate(R.layout.new_game, null);
        setContentView(R.layout.activity_main);


    }
    public void onPressed(View view) {
//        Button newGame = findViewById(R.id.newGame);
        Log.d("msg", "you got here");
        setContentView(configView);

//        newGame.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("msg", "you got here");
//            }
//        });
    }
}
