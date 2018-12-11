package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.provider.MediaStore;
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
    private KittyCats[] kittyCats;
    private int kittyCount = 5;
    static MediaPlayer gameMusic;
    final MediaPlayer catSnatchingSound;

    //creating a constructor for the Crazy Cat Lady!
    public CatLadyGameView(Context context, int  screenX, int screenY){
        super(context);
        catLady = new CatLady(context, screenX, screenY);
        surfaceHolder = getHolder();
        paint = new Paint();

        kittyCats = new KittyCats[kittyCount];
        for (int i = 0; i < kittyCount; i++){
            kittyCats[i] = new KittyCats(context, screenX, screenY);
        }

        //adding music and sfx
        gameMusic = MediaPlayer.create(context,R.raw.in_game_music);
        catSnatchingSound = MediaPlayer.create(context,R.raw.meow_collision);

        gameMusic.start();

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
                catLady.stopRunning();
                break;
            case MotionEvent.ACTION_DOWN:
                catLady.setRunning();
                break;
        }
        return true;
    }

    private void update(){
        catLady.update();

        for (int i = 0; i < kittyCount; i++){
            kittyCats[i].update(catLady.getSpeed());

            if (Rect.intersects(catLady.getCollDetection(), kittyCats[i].getCollDetection())){
                catSnatchingSound.start();
                kittyCats[i].setX(-1000);
            }
        }
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

            //Adding KittyCats to the game space
            for (int i = 0; i < kittyCount; i++){
                canvas.drawBitmap(
                        kittyCats[i].getBitmap(),
                        kittyCats[i].getX(),
                        kittyCats[i].getY(),
                        paint
                );
            }
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
