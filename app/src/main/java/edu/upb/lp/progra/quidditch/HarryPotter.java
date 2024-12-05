package edu.upb.lp.progra.quidditch;

public class HarryPotter {
    private int vertical = 5;
    private int horizontal = 2;
    private QuidditchGame game;

    public HarryPotter(QuidditchGame game) {
        this.game = game;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void derecha() {
        if (horizontal == 4){
            //ver si no esta al borde derecho
        }else if (horizontal >= 0){
            game.borrarHarry(horizontal);
            horizontal++;
            game.dibujarHarry(horizontal);
        }
    }

    public void izquierda(){
        if (horizontal > 0){
            game.borrarHarry(horizontal);
            horizontal--;
            game.dibujarHarry(horizontal);
        }
    }
}
