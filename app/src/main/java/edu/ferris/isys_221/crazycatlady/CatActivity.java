//Name: Chris Cosnowski
//Date Written: 12/07/2018
//Instructor: Hira Herrington
//Course: ISYS 221–VL1 Fully Online
//Purpose: Final Project - a game of cat snatching!
//Inputs/Outputs:
//Exposed Interfaces:
//Variables/Types:


package edu.ferris.isys_221.crazycatlady;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//Something will be clicked
public class CatActivity extends AppCompatActivity implements View.OnClickListener {

    //Instantiates the Play button image
    private ImageButton btn_Play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        //Landscape orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //gets Play button
        btn_Play = (ImageButton) findViewById(R.id.btn_play);

        //links the click listener to the Play button
        btn_Play.setOnClickListener(this);

        //this.setContentView(new GameSpace(this));
    }

    @Override
    public void onClick(View view){

        //starts the game
        startActivity(new Intent(this, CatLadyGameActivity.class));
    }
}
