package edu.gatech.cs2340.milestones.spacetraders.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.milestones.spacetraders.R;

public class MainActivity extends AppCompatActivity {

    private View configView;
    private Button button;
    private MediaPlayer click;
    /**
     * Layout setup
     * @param savedInstanceState previous configuration
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        configView = getLayoutInflater().inflate(R.layout.new_game, null);
        setContentView(R.layout.activity_main);

        final MediaPlayer gameMusic = MediaPlayer.create(this, R.raw.gamemusic);
        gameMusic.start();
        button = findViewById(R.id.newGame);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressed(view);
            }
        });

    }

    /**
     * Pressed Activity
     * @param view
     */
    public void onPressed(View view) {
        Log.d("msg", "you got here");
        click = MediaPlayer.create(this,R.raw.clicksound);
        click.start();
        click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
    }

    /**
     * Resume Activity
     * @param view
     */
    public void onResume(View view) {
        Log.d("resume:", "resume started");

        click = MediaPlayer.create(this,R.raw.clicksound);
        click.start();
        click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
    }
}
