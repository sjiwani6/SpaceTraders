package edu.gatech.cs2340.milestones.spacetraders.model;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.milestones.spacetraders.entity.Player;
import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;

class Repository {

    private Player player;
    //for m7 convenience only using 1 universe with 10 planets
    private Universe universe;
    private DatabaseReference mDatabase;

    /**
     * Constructor for repostiory
     */
    public Repository() {
        player = new Player();
        universe = new Universe();

    }

    /**
     * Getter for the player
     * @return player
     */
    public Player getPlayer() {
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        ValueEventListener playerListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Player player = dataSnapshot.getValue(Player.class);
//                Log.d("return right player?:", player.toString());
//                // ...
//                //ineed to handle here
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w("error:", "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        };
//
//        mDatabase.child("player").child("1").addListenerForSingleValueEvent(playerListener);

        return player;
    }


    /**
     * Getter for unidverse from database
     * @return universe from database
     */
    public Universe getUniverse() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener universeListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Universe universe = dataSnapshot.getValue(Universe.class);
                // ...
                setUniverse(universe);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("error:", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.child("universe").child("1").addListenerForSingleValueEvent(universeListener);
        return universe;
    }

    /**
     * Setter for the player
     * @param player the settings it will be updated to
     */
    public void setPlayer(Player player) {
        Log.d("does data base set player:", player.toString());
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        Gson gson = new Gson();
//        String json = gson.toJson(player);
//        Log.d("json", json);
        mDatabase.child("player").child("1").setValue(player);


        this.player = player;
    }

    /**
     * Setter for the universe
     * @param universe the settings the universe will be updated to
     */
    public void setUniverse(Universe universe) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("universe").child("1").setValue(universe);

        this.universe = universe;
    }

    /**
     * Updating the player to the passed player's settings
     * @param player whose settings the player's settings will be changed to
     */
    public void updatePlayer(Player player) {
        player.setCredit(player.getCredit());
        player.setEngineerPoint(player.getEngineerPoint());
        player.setFighterPoint(player.getFighterPoint());
        player.setName(player.getName());
        player.setPilotPoint(player.getPilotPoint());
        player.setTradePoint(player.getTradePoint());

        mDatabase = FirebaseDatabase.getInstance().getReference();
//        Gson gson = new Gson();
//        String json = gson.toJson(player);
        mDatabase.child("player").child("1").setValue(player);

    }
}
