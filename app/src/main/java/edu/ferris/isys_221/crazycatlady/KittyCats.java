package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.Random;

public class KittyCats {

    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 2;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;

    public KittyCats(Context context, int screenX, int screenY){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.cat_white);

        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;

        Random catGenerator = new Random();
        speed = catGenerator.nextInt(6) + 10;
        x = screenX;
        y = catGenerator.nextInt(maxY) - bitmap.getHeight();
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
