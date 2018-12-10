package edu.ferris.isys_221.crazycatlady;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/*public class UpdateGame extends Thread {

    private boolean isRunning;
    private GameSpace gameSpace;
    private SurfaceHolder surfaceHolder;

    public UpdateGame(GameSpace gameSpace, SurfaceHolder surfaceHolder){
        this.gameSpace = gameSpace;
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run(){
        long startTime = System.nanoTime();

        while (isRunning){
            Canvas canvas = null;
            try{
                canvas = this.surfaceHolder.lockCanvas();

                synchronized (canvas){
                    this.gameSpace.updateToon();
                    this.gameSpace.draw(canvas);
                }
            }catch (Exception e){

            }finally {
                if (canvas != null){
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            long time = System.nanoTime();
            long waiting = (time - startTime)/1000000;
            if (waiting < 10){
                waiting = 10;
            }
            System.out.print("Loading: "+ waiting);

            try{
                this.sleep(waiting);
            }catch (InterruptedException e){

            }
            startTime = System.nanoTime();
            System.out.print(".");
        }
    }

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
}*/
