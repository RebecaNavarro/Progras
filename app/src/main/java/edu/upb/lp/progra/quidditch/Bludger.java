package edu.upb.lp.progra.quidditch;

import java.util.Random;

public class Bludger {

    private Random rnd = new Random();
    private int vertical = 0;
    private int horizontal = rnd.nextInt(5);
    private QuidditchGame game;
    private BajadorDeBludger bajador;

    public Bludger(QuidditchGame game) {
        this.game = game;
        bajador =  new BajadorDeBludger(this);
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void iniciaBludger() {
        game.aparecerBludger(horizontal, 0);
        bajador.start();
    }

    public void bajarBludger() {
        game.borrarBludger(horizontal, vertical);
        if (vertical < 5) {
                vertical++;
        } else if (vertical == 5) {
            horizontal = rnd.nextInt(5);
            vertical = 0;
        }
        game.aparecerBludger(horizontal, vertical);
    }
    public void pararBludger(){
        bajador.stop();
    }

    public void executeLater(Runnable r, int ms) {
        game.executeLater(r, ms);
    }
}
