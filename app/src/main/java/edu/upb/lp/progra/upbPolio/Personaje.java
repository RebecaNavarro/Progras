package edu.upb.lp.progra.upbPolio;

import java.util.Random;

public class Personaje {

    private UpbPolioGame game;

    private int posicion = 0;
    private int vida = 100;

    private String imagen;

    public Personaje(UpbPolioGame game, String imagen) {
        this.game = game;
        this.imagen = imagen;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getImagen() {
        return imagen;
    }

    public int getVida() {
        return vida;
    }

    public void deprimirse(int costo) {
        vida -= costo;
        game.actualizarVida(vida);
    }

    public void potenciador(int ganancia) {
        vida += ganancia;
        game.actualizarVida(vida);
    }

    //public void recibirCastigo(int perdida) {
     //   vida -= perdida;
    //}

    public void mostrarMensaje (String mensaje){
        game.mostrarTexto(mensaje);
    }

    public void avanzar(int rnd) {
        if (posicion + rnd > 18) {
            game.victoria();
        }  else {
            int viejaPosicion = posicion;
            posicion += rnd;
            game.actualizarCasilla(viejaPosicion);
            game.actualizarCasilla(posicion);
            game.jugadorLlegaACasilla(posicion);
        }
        if (posicion <=18 && vida <= 0) {
           game.perder();
        }

    }

    public void retroceder(int retroceso) {
        int viejaPosicion = posicion;
        posicion -= retroceso;
        game.actualizarCasilla(viejaPosicion);
        game.actualizarCasilla(posicion);
    }

}
