package edu.upb.lp.progra.elMejorJuegoSuperMegaDivertido;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class ElMejorJuegoSuperMegaDivertidoUI implements UI {
    private AndroidGameGUI gui;

    public ElMejorJuegoSuperMegaDivertidoUI(AndroidGameGUI gui){
        this.gui=gui;
    }

    @Override
    public void onButtonPressed(String name) {

    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        gui.showTemporaryMessage("Vamonos");
    }

    @Override
    public void initialiseInterface() { //Que aparece primero
        gui.configureScreen(3, 3, 2, 2, true, 0.3 );//2: de espacio para que se vean los cuadrados de la matriz
        for(int v = 0 ; v < 3; v++){
            for(int h = 0; h < 3; h++){ //recorrer la matriz de 3x3
                gui.setImageOnCell(v, h, "colors_grey"); //v,h, "nombre del archivo de la imagen== sin espacio ni mayuscula"
            }
        }
    }
}
