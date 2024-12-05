package edu.upb.lp.progra.quidditch;

public class BajadorDeSnitch implements Runnable {
    private Snitch snitch;
    private boolean running = false;

    public BajadorDeSnitch(Snitch snitch){
        this.snitch = snitch;
    }

    public void start(){
        if(!running){
            running = true;
            snitch.executeLater(this, 1000);
        }
    }

    public void stop(){
        running = false;
    }

    @Override
    public void run(){
        if(running){
            snitch.bajarSnitch();
            snitch.executeLater(this,500);
        }
    }
}
