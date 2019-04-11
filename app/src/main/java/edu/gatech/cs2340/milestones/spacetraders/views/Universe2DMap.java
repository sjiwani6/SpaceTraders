package edu.gatech.cs2340.milestones.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Universe2DMap extends AppCompatActivity {
    private Button button;
    private View universeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //universeView = getLayoutInflater().inflate(R.layout.new_game, null);
       // setContentView(R.layout.activity_main);

       // button = findViewById(R.id.newGame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressed(view);
            }
        });
    }
    public void onPressed(View view) {
        Log.d("msg", "youre at the Universe map");
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
    }

}
