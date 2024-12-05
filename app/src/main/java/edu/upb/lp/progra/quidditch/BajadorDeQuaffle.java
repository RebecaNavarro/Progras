package edu.upb.lp.progra.quidditch;

public class BajadorDeQuaffle implements Runnable {
    private Quaffle quaffle;
    private boolean running = false;

    public BajadorDeQuaffle(Quaffle quaffle) {
        this.quaffle = quaffle;
    }

    public void start() {
        if (!running) {
            running = true;
            quaffle.executeLater(this, 1000);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        if (running) {
            quaffle.bajarQuaffle();
            quaffle.executeLater(this, 800);
        }
    }
}
