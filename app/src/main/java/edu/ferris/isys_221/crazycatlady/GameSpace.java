package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*
public class GameSpace extends SurfaceView implements SurfaceHolder.Callback {

    private UpdateGame updateGame;

    private CrazyCatLadyToon crazyCatLadyToon;

    public GameSpace(Context context){
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
    }
    public void updateToon(){
        this.crazyCatLadyToon.updateImages();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        this.crazyCatLadyToon.draw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.crazy_lady);
        this.crazyCatLadyToon = new CrazyCatLadyToon(this, bitmap, 100, 50);

        this.updateGame = new UpdateGame(this,holder);
        this.updateGame.setRunning(true);
        this.updateGame.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean tryAgain = true;
        while (tryAgain){
            try {
                this.updateGame.setRunning(false);
                this.updateGame.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            tryAgain = true;
        }
    }
}
*/
