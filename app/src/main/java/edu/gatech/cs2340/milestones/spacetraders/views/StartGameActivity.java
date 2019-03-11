package edu.gatech.cs2340.milestones.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.milestones.spacetraders.R;
public class StartGameActivity extends AppCompatActivity {

    private View configView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        button = (Button) findViewById(R.id.exitGame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                moveTaskToBack(true);
            }
        });

    }
}
