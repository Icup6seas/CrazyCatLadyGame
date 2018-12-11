package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CatLady {

    //Cat Lady attributes
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 0;
    private boolean running;
    private final int GRAVITY = -10;
    private int maxY;
    private int minY;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    public CatLady(Context context, int screenX, int screenY){
        x = 75;
        y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.crazy_lady);

        maxY = screenY - bitmap.getHeight();
        minY = 0;

        running = false;
    }

    public void setRunning(){
        running = true;
    }

    public void stopRunning(){
        running = false;
    }

    public void update(){
        if (running){
            speed += 2;
        }else {
            speed -= 5;
        }
        //setting MAX_SPEED
        if (speed > MAX_SPEED){
            speed = MAX_SPEED;
        }
        //setting MIN_SPEED
        if (speed < MIN_SPEED){
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;

        //protecting the Lady from wondering off of the screen
        if (y < minY){
            y = minY;
        }
        if (y > maxY){
            y = maxY;
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getSpeed(){
        return speed;
    }
}
