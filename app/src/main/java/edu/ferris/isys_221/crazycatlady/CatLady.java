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

    private final int MIN_SPEED = 0;
    private final int MAX_SPEED = 15;

    public CatLady(Context context){
        x = 60;
        y = 60;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.crazy_lady);

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

    /*protected Bitmap bitmap;

    protected final int rowCount;
    protected final int colCount;
    protected final int WIDTH;
    protected final int HEIGHT;
    protected final int width;
    protected final int height;
    protected int x;
    protected int y;


    public CatLady(Bitmap bitmap, int rowCount, int colCount, int x, int y){

        this.bitmap = bitmap;
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.x = x;
        this.y = y;
        this.WIDTH = bitmap.getWidth();
        this.HEIGHT = bitmap.getHeight();
        this.width = this.WIDTH / colCount;
        this.height = this.HEIGHT / rowCount;
    }

    protected Bitmap createImages(int row, int col){
        Bitmap createImage = Bitmap.createBitmap(bitmap, col*width, row*height, width, height);
        return createImage;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }*/
}
