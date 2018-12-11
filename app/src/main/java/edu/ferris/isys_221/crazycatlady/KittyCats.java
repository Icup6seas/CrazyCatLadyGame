package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class KittyCats {

    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 5;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private final int GRAVITY = -28;
    private final int MIN_SPEED = 5;
    private final int MAX_SPEED = 30;

    private Rect collDetection;

    public KittyCats(Context context, int screenX, int screenY){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.cat_white);

        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;

        Random catGenerator = new Random();
        speed = catGenerator.nextInt(10);
        x = catGenerator.nextInt(maxX);
        y = catGenerator.nextInt(maxY);

        collDetection = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update(int catSpeed){
        x -= catSpeed;
        y -= speed;
        if (x < minX - bitmap.getWidth()){
            Random catGenerator = new Random();
            speed = catGenerator.nextInt(10) + 10;
            x = maxX;
            y = catGenerator.nextInt(maxY) - bitmap.getHeight();
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

        if (y < minY){
            y = minY;
        }
        if (y > maxY){
            y = maxY;
        }

        collDetection.left = x;
        collDetection.top = y;
        collDetection.right = x + bitmap.getWidth();
        collDetection.bottom = y + bitmap.getHeight();
    }

    public void setX(int x){
        this.x = x;
    }

    public Rect getCollDetection(){
        return collDetection;
    }

    public Bitmap getBitmap(){
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
