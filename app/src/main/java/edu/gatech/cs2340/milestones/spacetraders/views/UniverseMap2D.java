package edu.gatech.cs2340.milestones.spacetraders.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import edu.gatech.cs2340.milestones.spacetraders.R;


public class UniverseMap2D extends Activity{
    private ImageView mDialog;


  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_2d_map);



        mDialog = (ImageView)findViewById(R.id.your_image);
        mDialog.setClickable(true);


        //finish the activity (dismiss the image dialog) if the user clicks
        //anywhere on the image
        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}