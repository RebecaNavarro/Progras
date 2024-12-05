package edu.upb.lp.progra.quidditch;

public class IniciadorDeSnitch implements Runnable{

    private Snitch snitch;
    private boolean running = false;

    public IniciadorDeSnitch(Snitch snitch){ this.snitch = snitch;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        if(running) {
            snitch.iniciaSnitch();
        }
    }
}
