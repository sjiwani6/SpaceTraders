package edu.gatech.cs2340.milestones.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.milestones.spacetraders.R;

public class MainActivity extends AppCompatActivity {

    private View configView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        configView = getLayoutInflater().inflate(R.layout.new_game, null);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.newGame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressed(view);
            }
        });

    }
    public void onPressed(View view) {
        Log.d("msg", "you got here");
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
    }
    public void onResume(View view) {
        Log.d("resume:", "resume started");

        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
    }
}
