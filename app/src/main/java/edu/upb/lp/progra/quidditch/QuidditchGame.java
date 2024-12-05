package edu.upb.lp.progra.quidditch;

import java.util.Random;

public class QuidditchGame {
    private QuidditchUI ui;
    //0: inicio, 1: instrucciones, 2: juego, 3:perderoganar
    private int pantalla = 0;
    private HarryPotter harry = new HarryPotter(this);
    private Snitch snitch = new Snitch(this);
    private int cantidadDeQuaffles = 2;
    private int cantidadDeBludgers = 2;
    private Bludger[] bludgers = new Bludger[cantidadDeBludgers];
    private Quaffle[] quaffles = new Quaffle[cantidadDeQuaffles];
    private IniciadorDeSnitch iniciadorDeSnitch = new IniciadorDeSnitch(snitch);

    public QuidditchGame(QuidditchUI ui){
        this.ui = ui;
    }

    public void clic(int vertical, int horizontal) {
        if (pantalla == 0) {
            ui.pantallaDeInstrucciones();
            pantalla = 1;
        } else if (pantalla == 1){
            ui.pantalladeJuego();
            pantalla = 2;
            for(int b = 0; b < bludgers.length; b++){
                bludgers[b] = new Bludger(this);
                bludgers[b].iniciaBludger();
            }
            for(int q = 0; q < quaffles.length; q++){
                quaffles[q] = new Quaffle(this);
                quaffles[q].iniciaQuaffle();
            }
            iniciadorDeSnitch.start();
            ui.executeLater(iniciadorDeSnitch,20000);
        } else if (pantalla == 2) {
            if (vertical == 6 && (horizontal == 3 || horizontal == 4)) {
                harry.derecha();
            } else if (vertical == 6 && (horizontal == 0 || horizontal == 1)) {
                harry.izquierda();
            }
        } else if (pantalla == 3) {
            ui.megaKill();
        }
    }
    public void dibujarHarry(int horizontal) {
        ui.dibujarHarry(horizontal);
    }

    public void borrarHarry(int horizontal) {
        ui.borrarHarry(horizontal);
    }

    public void aparecerQuaffle(int horizontal, int vertical) {
        if(vertical == 5 && harry.getHorizontal() == horizontal) {
            ui.mostrarPuntaje(3);
        } else {
            ui.aparecerQuaffle(horizontal, vertical);
        }
    }

    public void borrarQuaffle(int horizontal,int vertical) {
        if(vertical < 5 || harry.getHorizontal() != horizontal) {
            ui.dibujarPasto(horizontal, vertical);
        }
    }

    public void aparecerBludger(int horizontal, int vertical) {
        if (vertical < 5) {
            ui.aparecerBludger(horizontal, vertical);
        }else if (vertical == 5){
            if(harry.getHorizontal() == horizontal) {
                perder();
            }else{
                ui.mostrarPuntaje(1);
                ui.aparecerBludger(horizontal, vertical);
            }
        }
    }

    public void borrarBludger(int horizontal, int vertical) {
        ui.dibujarPasto(horizontal, vertical);
    }

    public void aparecerSnitchMasTarde() {
        ui.executeLater(iniciadorDeSnitch,5000);
    }

    public void aparecerSnitch(int horizontal, int vertical) {
        if (vertical < 5) {
            ui.aparecerSnitch(horizontal, vertical);
        }else if (vertical == 5){
            if(harry.getHorizontal() == horizontal) {
                ganar();
            }else{
                ui.aparecerSnitch(horizontal, vertical);
            }
        }
    }

    public void borrarSnitch(int horizontal, int vertical) {
        ui.dibujarPasto(horizontal, vertical);
    }
    public void executeLater(Runnable r, int ms) {
        ui.executeLater(r,ms);
    }

    public void perder(){
        detenerTodo();
        pantalla = 3;
        ui.perder();
    }

    public void ganar(){
        detenerTodo();
        pantalla = 3;
        ui.ganar();
    }

    private void detenerTodo() {
        snitch.pararSnitch();
        iniciadorDeSnitch.stop();
        for(int b = 0; b < bludgers.length; b++){
            bludgers[b].pararBludger();
        }
        for(int q = 0; q < quaffles.length; q++){
            quaffles[q].pararQuaffle();
        }
    }
}
