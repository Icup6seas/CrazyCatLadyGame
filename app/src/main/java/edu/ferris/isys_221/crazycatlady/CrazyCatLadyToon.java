package edu.ferris.isys_221.crazycatlady;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.MainThread;

public class CrazyCatLadyToon extends CatLady {

    private static final int COL_TOP_TO_BOTTOM = 0;
    private static final int COL_RIGHT_TO_LEFT = 2;
    private static final int COL_LEFT_TO_RIGHT = 3;
    private static final int COL_BOTTOM_TO_TOP = 1;

    private int colStartUsing = COL_LEFT_TO_RIGHT;
    private int rowStartUsing;

    public Bitmap[] leftToRight;
    public Bitmap[] rightToLeft;
    public Bitmap[] topToBottom;
    public Bitmap[] bottomToTop;

    public static final float SPEED = 0.1f;
    private int movingVectorX = 10;
    private int movingVectorY = 5;

    private long lastDrawnImage = -1;

    private GameSpace gameSpace;

    public CrazyCatLadyToon(GameSpace gameSpace, Bitmap bitmap, int x, int y){
        super(bitmap, 4, 3, x, y);

        this.gameSpace = gameSpace;
        this.topToBottom = new Bitmap[rowCount];
        this.rightToLeft = new Bitmap[rowCount];
        this.leftToRight = new Bitmap[rowCount];
        this.bottomToTop = new Bitmap[rowCount];

        for (int row = 0; row < this.rowCount; row++){
            this.topToBottom[row] = this.createImages(COL_TOP_TO_BOTTOM, row);
            this.rightToLeft[row] = this.createImages(COL_RIGHT_TO_LEFT, row);
            this.leftToRight[row] = this.createImages(COL_LEFT_TO_RIGHT, row);
            this.bottomToTop[row] = this.createImages(COL_BOTTOM_TO_TOP, row);
        }
    }

    public Bitmap[] movementImages(){
        switch (colStartUsing){
            case COL_BOTTOM_TO_TOP: return this.bottomToTop;
            case COL_LEFT_TO_RIGHT: return this.leftToRight;
            case COL_RIGHT_TO_LEFT: return this.rightToLeft;
            case COL_TOP_TO_BOTTOM: return this.topToBottom;
            default: return null;
        }
    }

    public Bitmap currentMoveImage(){
        Bitmap[] bitmaps = this.movementImages();
        return bitmaps[this.rowStartUsing];
    }

    public void updateImages(){
        this.rowStartUsing++;
        if (rowStartUsing >= this.rowCount){
            this.rowStartUsing = 0;
        }
        long time = System.nanoTime();
        if (lastDrawnImage == -1){
            lastDrawnImage = time;
        }

        //math conversion of time
        int changeInTime = (int)((time - lastDrawnImage)/1000000);

        //distance of movement
        float distCovered = SPEED*changeInTime;
        double moveLength = Math.sqrt(movingVectorX * movingVectorX + movingVectorY * movingVectorY);

        //new position of Crazy Lady Object
        this.x = x + (int)(distCovered * movingVectorX / moveLength);
        this.y = y + (int)(distCovered * movingVectorY / moveLength);

        //End of screen collision detection
        if (this.x < 0){
            this.x = 0;
            this.movingVectorX =- this.movingVectorX;
        }else if (this.x > this.gameSpace.getWidth() - width){
            this.x = this.gameSpace.getWidth() - width;
            this.movingVectorX =- this.movingVectorX;
        }

        if (this.y < 0){
            this.y = 0;
            this.movingVectorY =- this.movingVectorY;
        }else if (this.y > this.gameSpace.getHeight() - height){
            this.y = this.gameSpace.getHeight() - height;
            this.movingVectorY =- this.movingVectorY;
        }

        if (movingVectorX > 0){
            if (movingVectorY > 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)){
                this.colStartUsing = COL_TOP_TO_BOTTOM;
            }else if (movingVectorY < 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)){
                this.colStartUsing = COL_BOTTOM_TO_TOP;
            }else{
                this.colStartUsing = COL_LEFT_TO_RIGHT;
            }
        }else {
            if (movingVectorY > 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)){
                this.colStartUsing = COL_TOP_TO_BOTTOM;
            }else if (movingVectorY < 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)){
                this.colStartUsing = COL_BOTTOM_TO_TOP;
            }else{
                this.colStartUsing = COL_RIGHT_TO_LEFT;
            }
        }
    }

    public void write(Canvas canvas){
        Bitmap bitmap = this.currentMoveImage();
        canvas.drawBitmap(bitmap, x, y, null);
        this.lastDrawnImage = System.nanoTime();
    }

    public void movingVector(int movingVectorX, int movingVectorY){
        this.movingVectorX = movingVectorX;
        this.movingVectorY = movingVectorY;
    }
}
