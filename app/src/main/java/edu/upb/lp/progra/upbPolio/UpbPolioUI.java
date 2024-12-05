package edu.upb.lp.progra.upbPolio;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;
import edu.upb.lp.progra.upbPolio.UpbPolioGame;

public class UpbPolioUI implements UI {

    private AndroidGameGUI gui;
    private UpbPolioGame game = new UpbPolioGame(this);

    public UpbPolioUI(AndroidGameGUI gui) {
        this.gui = gui;
    }


    @Override
    public void onButtonPressed(String name) {
    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
        try {
            game.clic(vertical, horizontal);
        } catch (NumeroDePantallaIncorrectoException e){// e variable de exception
            gui.showTemporaryMessage("Reinicia el juego :'(");
        }
    }

    @Override
    public void initialiseInterface() {
        gui.configureScreen(1, 1, 0, 0, true, 0);
        gui.setImageOnCell(0, 0, "inicio_b");
    }

    public void instrucciones() {
        gui.configureScreen(1, 1, 0, 0, true, 0);
        gui.setImageOnCell(0, 0, "instrucciones");
    }

    public void eleccionPersonaje() {
        gui.configureScreen(1, 2, 0, 1, true, 0);
        gui.setImageOnCell(0, 0, "moto");
        gui.setImageOnCell(0, 1, "perrito");
    }

    public void pantallaDeJuego() {
        gui.configureScreen(8, 5, 0, 0, true, 0);
        for (int v = 0; v < 8; v++) {
            for (int h = 0; h < 5; h++) {
                gui.setImageOnCell(v, h, "negro");
            }
        }

        gui.setImageOnCell(0, 0, "carcel");
        gui.setImageOnCell(0, 1, "blanco");
        gui.setImageOnCell(0, 2, "bvuses");
        gui.setImageOnCell(0, 3, "blanco");
        gui.setImageOnCell(0, 4, "cafe");

        gui.setImageOnCell(1, 0, "blanco");
        gui.setImageOnCell(1, 4, "blanco");

        gui.setImageOnCell(2, 0, "cas_fortu");
        gui.setImageOnCell(2, 4, "cas_castig");

        gui.setImageOnCell(3, 0, "calculo");
        gui.setImageOnCell(3, 4, "cas_fortu");

        gui.setImageOnCell(4, 0, "cas_castig");
        gui.setImageOnCell(4, 4, "fisica");

        gui.setImageOnCell(5, 0, "suerte");
        gui.setImageOnCell(5, 4, "blanco");

        gui.setImageOnCell(6, 0, "inicio");
        gui.setImageOnCell(6, 1, "finaltodo");
        gui.setImageOnCell(6, 2, "metodos_numericos");
        gui.setImageOnCell(6, 3, "blanco");
        gui.setImageOnCell(6, 4, "vas_carcel"); //retro

        gui.setImageOnCell(2, 2, "plomito");
        gui.setImageOnCell(4, 2, "plomito");

        gui.setImageOnCell(7, 0, "puntaje");

        gui.setImageOnCell(7, 2, "dado");
        gui.setImageOnCell(7, 3, "blanco");
        gui.setImageOnCell(7, 4, "blanco");
        gui.setTextOnCell(7, 1, 100 + "");

    }

    public void ganar() {
        gui.configureScreen(1, 1, 0, 0, true, 0);
        gui.setImageOnCell(0, 0, "ganar");
    }

    public void perder() {
        gui.configureScreen(1, 1, 0, 0, true, 0);
        gui.setImageOnCell(0, 0, "perdiste");
    }

    public void dibujarPersonaje(String imagen, int posicion) {
        if (posicion == 0) {
            gui.setImageOnCell(5, 1, imagen + "esqizq");
        } else if (posicion < 6) {
            gui.setImageOnCell(6 - posicion, 1, imagen + "izquierda");
        } else if (posicion == 6) {
            gui.setImageOnCell(1, 1, imagen + "esqizqarr");
        } else if (posicion < 10) {
            gui.setImageOnCell(1, posicion - 6, imagen + "arriba");
        } else if (posicion == 10) {
            gui.setImageOnCell(1, 3, imagen + "esqderarr");
        } else if (posicion < 16) {
            gui.setImageOnCell(posicion - 10, 3, imagen + "derecha");
        } else if (posicion == 16) {
            gui.setImageOnCell(5, 3, imagen + "esqder");
        } else {
            gui.setImageOnCell(5, 20 - posicion, imagen + "normal");
        }

    }

    public void borarrPersonaje(int posicion) {

        if (posicion == 0) {
            gui.setImageOnCell(5, 1, "negro");
        } else if (posicion < 6) {
            gui.setImageOnCell(6 - posicion, 1, "negro");
        } else if (posicion == 6) {
            gui.setImageOnCell(1, 1, "negro");
        } else if (posicion < 10) {
            gui.setImageOnCell(1, posicion - 6, "negro");
        } else if (posicion == 10) {
            gui.setImageOnCell(1, 3, "negro");
        } else if (posicion < 16) {
            gui.setImageOnCell(posicion - 10, 3, "negro");
        } else if (posicion == 16) {
            gui.setImageOnCell(5, 3, "negro");
        } else {
            gui.setImageOnCell(5, 20 - posicion, "negro");
        }
    }

    public void mostrarDado(int rnd) {
        gui.showTemporaryMessage("Resultado del dado: " + rnd);
    }

    public void actualizarVida(int vida) {
        gui.setTextOnCell(7, 1, vida + "");
    }

    public void mostrarTextito(String mensaje) {
        gui.showTemporaryMessage(mensaje);
    }

    public void mostrarTextoFortuna(String mensajeCartas) {
        gui.setTextOnCell(2, 2, mensajeCartas);
    }

    public void mostrarTextoCastigo(String mensajeCartas) {
        gui.setTextOnCell(4, 2, mensajeCartas);
    }

}
