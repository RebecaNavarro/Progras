package edu.upb.lp.progra.quidditch;

import java.util.Random;

public class Snitch {
    private Random rnd = new Random();
    private int vertical = 0;
    private int horizontal = rnd.nextInt(5);
    private QuidditchGame game;
    private BajadorDeSnitch bajador = new BajadorDeSnitch(this);

    public Snitch(QuidditchGame game) {
        this.game = game;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void iniciaSnitch() {
        game.aparecerSnitch(horizontal, 0);
        bajador.start();
    }
    public void bajarSnitch(){
            if (vertical < 5) {
                game.borrarSnitch(horizontal, vertical);
                vertical++;
                game.aparecerSnitch(horizontal, vertical);
            } else if (vertical == 5) {
                bajador.stop();
                game.borrarSnitch(horizontal, vertical);
                horizontal = rnd.nextInt(5);
                vertical = 0;
                game.aparecerSnitchMasTarde();
            }
    }

    public void pararSnitch(){
        bajador.stop();
    }

    public void executeLater(Runnable r, int ms) {
        game.executeLater(r,ms);
    }
}





