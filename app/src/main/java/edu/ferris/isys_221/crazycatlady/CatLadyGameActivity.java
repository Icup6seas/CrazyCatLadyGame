package edu.ferris.isys_221.crazycatlady;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CatLadyGameActivity extends AppCompatActivity {

    //Declaring CatLadyGameView
    private CatLadyGameView catLadyGameView;


    //Starting the catLadyGameView, adding it to the contentView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        catLadyGameView = new CatLadyGameView(this);
        setContentView(catLadyGameView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        catLadyGameView.pauseGame();
    }

    @Override
    protected void onResume(){
        super.onResume();
        catLadyGameView.resumeGame();
    }
}
