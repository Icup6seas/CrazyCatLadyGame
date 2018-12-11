package edu.ferris.isys_221.crazycatlady;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class CatLadyGameActivity extends AppCompatActivity {

    //Declaring CatLadyGameView
    private CatLadyGameView catLadyGameView;


    //Starting the catLadyGameView, adding it to the contentView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        catLadyGameView = new CatLadyGameView(this, point.x, point.y);
        setContentView(catLadyGameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        catLadyGameView.pauseGame();
    }

    @Override
    protected void onResume() {
        super.onResume();
        catLadyGameView.resumeGame();
    }
}
