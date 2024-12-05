package edu.upb.lp.progra.quidditch;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class QuidditchUI implements UI {

    private AndroidGameGUI gui;
    private QuidditchGame game = new QuidditchGame(this);
    private int puntos = 0;
    public QuidditchUI(AndroidGameGUI gui) {
        this.gui = gui;
    }

    @Override
    public void onButtonPressed(String name) {
    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {game.clic(vertical, horizontal);}

    @Override
    public void initialiseInterface() {
        gui.configureScreen(1, 1, 0, 0, true, 0);
        gui.setImageOnCell(0, 0, "inicio_hp");
    }

    public void pantallaDeInstrucciones() {
        gui.setImageOnCell(0,0, "instrucciones");
    }

    public void pantalladeJuego() {
        gui.configureScreen(7,5,0,0,true,0);
        for(int v = 0; v < 6; v++){
            for(int h = 0; h < 5; h++) {
                gui.setImageOnCell(v, h, "pasto");
            }
        }
        gui.setImageOnCell(6,0,"izqu");
        gui.setImageOnCell(6,1,"ierda");
        gui.setImageOnCell(6,2,"puntaje");
        gui.setImageOnCell(6,3,"dere");
        gui.setImageOnCell(6,4,"cha");
        gui.setTextOnCell(6,2, "" + 0);
        dibujarHarry(2);
    }

    public void dibujarHarry(int horizontal) {
        gui.setImageOnCell(5,horizontal,"harry_pasto");
    }

    public void borrarHarry(int horizontal) {
        gui.setImageOnCell(5,horizontal,"pasto");
    }

    public void aparecerQuaffle(int horizontal, int vertical) {gui.setImageOnCell(vertical, horizontal,"quaffle_pasto");
    }

    public void aparecerBludger(int horizontal, int vertical) {
        gui.setImageOnCell(vertical, horizontal, "bludger_pasto");
    }

    public void aparecerSnitch(int horizontal, int vertical) {
        gui.setImageOnCell(vertical, horizontal, "snitch_pasto");
    }

    public void dibujarPasto(int horizontal, int vertical){
        gui.setImageOnCell(vertical, horizontal, "pasto");
    }

    public void executeLater(Runnable r, int ms) {
        gui.executeLater(r,ms);
    }

    public void mostrarPuntaje(int puntaje){
        if(puntaje == 3) {
            puntos += 3;
            gui.setTextOnCell(6, 2, "" + puntos);
        }else {
            puntos++;
            gui.setTextOnCell(6, 2, "" + puntos);
            }
    }

    public void ganar() {
        gui.configureScreen(1,1,0,0,true,0);
        gui.setImageOnCell(0,0,"ganaste");
    }

    public void perder() {
        gui.configureScreen(1,1,0,0,true,0);
        gui.setImageOnCell(0,0,"perdiste");
    }

    public void megaKill() {
        initialiseInterface();
        game = new QuidditchGame(this);
    }
}
