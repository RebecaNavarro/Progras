package edu.upb.lp.progra.quidditch;

import java.util.Random;

public class Quaffle {
    private Random rnd = new Random();
    private int vertical = 0;
    private int horizontal = rnd.nextInt(5);
    private QuidditchGame game;
    private BajadorDeQuaffle bajador = new BajadorDeQuaffle(this);

    public Quaffle(QuidditchGame game) {
        this.game = game;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void iniciaQuaffle(){
        game.aparecerQuaffle(horizontal, 0);
        bajador.start();
    }

    public void bajarQuaffle(){
        game.borrarQuaffle(horizontal, vertical);
        if (vertical < 5) {
            vertical++;
            game.aparecerQuaffle(horizontal, vertical);
        } else if (vertical == 5) {
            horizontal = rnd.nextInt(5);
            vertical = 0;
        }
        game.aparecerQuaffle(horizontal, vertical);
    }

    public void pararQuaffle(){
        bajador.stop();
    }

    public void executeLater(Runnable r, int ms) {
        game.executeLater(r,ms);
    }
}
