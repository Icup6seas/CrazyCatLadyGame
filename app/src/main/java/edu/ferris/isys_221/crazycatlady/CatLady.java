package edu.ferris.isys_221.crazycatlady;

import android.graphics.Bitmap;

public class CatLady {

    //Cat Lady attributes
    //private Bitmap bitmap;
    //private int x;
    //private int y;
    //private int speed = 0;

    protected Bitmap bitmap;

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
    }
}
