package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CatLadyGameView extends SurfaceView implements Runnable {

    //declaring isPlaying
    volatile boolean isPlaying;
    private Thread catLadyGameThread = null;
    private CatLady catLady;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;


    //creating a constructor!
    public CatLadyGameView(Context context){
        super(context);

        catLady = new CatLady(context);
        surfaceHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying){
            update();
            drawFrame();
            controlFrame();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_DOWN:

                break;
        }
        return true;
    }

    private void update(){
        catLady.update();
    }

    //Valid location, background and Cat Lady
    private void drawFrame(){
        if (surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
            canvas.drawBitmap(
                    catLady.getBitmap(),
                    catLady.getX(),
                    catLady.getY(),
                    paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void controlFrame(){
        try {
            catLadyGameThread.sleep(17);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //pause game because not playing, stops game thread
    public void pauseGame(){
        isPlaying = false;
        try {
            catLadyGameThread.join();
        }catch (InterruptedException e){

        }
    }

    //resumes game because playing, starts game thread
    public void resumeGame(){
        isPlaying = true;
        catLadyGameThread = new Thread(this);
        catLadyGameThread.start();
    }
}
