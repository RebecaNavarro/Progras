package edu.upb.lp.progra.quidditch;

public class BajadorDeBludger implements Runnable {
    private Bludger bludger;
    private boolean running = false;
    private int delay = 600;

    public BajadorDeBludger(Bludger bludger) {
        this.bludger = bludger;
    }

    public void start() {
        if (!running) {
            running = true;
            bludger.executeLater(this, 1000);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        if (running) {
            bludger.bajarBludger();
            bludger.executeLater(this, delay);
        }
    }
}
