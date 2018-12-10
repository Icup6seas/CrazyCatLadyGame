package edu.ferris.isys_221.crazycatlady;

import android.content.Context;
import android.view.SurfaceView;

public class CatLadyGameView extends SurfaceView implements Runnable {

    //declaring isPlaying
    volatile boolean isPlaying;

    private Thread catLadyGameThread = null;

    //creating a constructor!
    public CatLadyGameView(Context context){
        super(context);
    }

    @Override
    public void run() {
        while (isPlaying){
            updateFrame();
            writeFrame();
            controlFrame();
        }
    }

    private void updateFrame(){

    }

    private void writeFrame(){

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
