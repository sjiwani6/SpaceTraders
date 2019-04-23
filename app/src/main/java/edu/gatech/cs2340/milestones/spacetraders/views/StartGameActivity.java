package edu.gatech.cs2340.milestones.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.ConfigurationViewModel;
import edu.gatech.cs2340.milestones.spacetraders.viewmodel.UniverseViewModel;


public class StartGameActivity extends AppCompatActivity {

    private Button button;
    private ConfigurationViewModel viewModel;
    private UniverseViewModel universeViewModel;
    private DatabaseReference mDatabase;
    private MediaPlayer click;

    /**
     * Sets up start of game
     * @param savedInstanceState configuration
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);


        final TextView nameField = findViewById(R.id.name);
        final TextView pilotPoint = findViewById(R.id.p_count);
        final TextView engineerPoint = findViewById(R.id.e_count);
        final TextView tradePoint = findViewById(R.id.t_count);
        final TextView fighterPoint = findViewById(R.id.f_count);

        Player player = viewModel.getPlayer();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener playerListener = new ValueEventListener() {

            /**
             * Manipulates player data
             * @param dataSnapshot input data
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Player player = dataSnapshot.getValue(Player.class);
                Log.d("return right player?:", player.toString());
                // ...
                //ineed to handle here
                nameField.setText(player.getName());
                pilotPoint.setText(""+player.getPilotPoint());
                engineerPoint.setText(""+player.getEngineerPoint());
                tradePoint.setText(""+player.getTradePoint());
                fighterPoint.setText(""+player.getFighterPoint());
                viewModel.addPlayer(player);
            }

            /**
             * Logs error and cancels action
             * @param databaseError error from database
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("error:", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        ValueEventListener universeListener = new ValueEventListener() {

            /**
             * Manipulates universe data
             * @param dataSnapshot input data
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Universe universe = dataSnapshot.getValue(Universe.class);
                Log.d("return right player?:", universe.toString());
                // ...
                //ineed to handle here();
                universeViewModel.addUniverse(universe);
            }

            /**
             * Logs error and cancels action
             * @param databaseError error from database
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("error:", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        mDatabase.child("player").child("1").addListenerForSingleValueEvent(playerListener);
        mDatabase.child("universe").child("1").addListenerForSingleValueEvent(universeListener);


    }

    /**
     * Market Activity
     * @param view
     */
    public void onMarket(View view) {
        click = MediaPlayer.create(this,R.raw.clicksound);
        click.start();
        click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });
        Intent intent = new Intent(this, UniverseActivity.class);
        startActivity(intent);
    }

    /**
     * Travel Activity
     * @param view
     */
    public void onTravel(View view) {
        click = MediaPlayer.create(this,R.raw.clicksound);
        click.start();
        click.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });
        Intent intent = new Intent(this, TravelActivity.class);
        startActivity(intent);
    }
}
