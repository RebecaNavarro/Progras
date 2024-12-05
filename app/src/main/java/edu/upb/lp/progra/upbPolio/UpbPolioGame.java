package edu.upb.lp.progra.upbPolio;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class UpbPolioGame {

    private Personaje jugador1;

    private UpbPolioUI ui;
    private int pantalla = 0;
    private Random rnd = new Random();
    private int dado;

    private LinkedList<ElementoConEfecto> casillas = new LinkedList<>(); //lista
    private Queue<Carta> lc = new LinkedList<>(); // cola
    private Queue<Carta> lf = new LinkedList<>();

    //TODO excepcion: se vuelve a imprimir la lista para que no se quede sin elementos

    public UpbPolioGame(UpbPolioUI upbPolioUI) {
        this.ui = upbPolioUI;

        lf.offer(new Carta(this, 5, "Hay hamacas +5"));
        lf.offer(new Carta(this, 10, "No hay clases +10"));
        lf.offer(new Carta(this, 15, "Exceso de belleza +15"));
        lf.offer(new Carta(this, 5, "No te cobran el bus +5"));

        lc.offer(new Carta(this, -5, "Hiciste trampa -5"));
        lc.offer(new Carta(this, -10, "No subiste la vara -10"));
        lc.offer(new Carta(this, -15, "Te quitaron tu vape -15"));
        lc.offer(new Carta(this, -10, "Te faltan 10 horas becarias -10"));

        casillas.add(new CasBlanco(this));
        casillas.add(new CasBlanco(this)); //1
        casillas.add(new CasCastigo(this));
        casillas.add(new CasMateria(this, 25,"Te reduce 20 de estabilidad emocional"));
        casillas.add(new CasFortuna(this));
        casillas.add(new CasBlanco(this));
        casillas.add(new CasCarcel(this));
        casillas.add(new CasBlanco(this));
        casillas.add(new CasBus(this));
        casillas.add(new CasBlanco(this));
        casillas.add(new CasCafe(this));
        casillas.add(new CasBlanco(this));
        casillas.add(new CasCastigo(this));
        casillas.add(new CasFortuna(this));
        casillas.add(new CasMateria(this, 35,"Te reduce 30 de estabilidad emocional :("));
        casillas.add(new CasBlanco(this));
        casillas.add(new CasRetro(this));
        casillas.add(new CasBlanco(this));
        casillas.add(new CasMateria(this, 45, "Te reduce 40 de estabilidad emocional :("));
    }

    public int getPantalla() {
        return pantalla;
    }

    public int getDado() {
        return dado = rnd.nextInt(3) + 1;
    }

    public void clic(int vertical, int horizontal) throws NumeroDePantallaIncorrectoException {
        //0: inicio, 1: instrucciones, 2: elegir personaje, 3: juego, 4: ganar, 5: perder
        if (pantalla == 0) {
            ui.instrucciones();
            pantalla = 1;
        } else if (pantalla == 1) {
            ui.eleccionPersonaje();
            pantalla = 2;
        } else if (pantalla == 2) {
            ui.pantallaDeJuego();
            if (horizontal == 0) {
                jugador1 = new Personaje(this, "moto");
                ui.dibujarPersonaje("moto", 0);
            } else {
                jugador1 = new Personaje(this, "perro");
                ui.dibujarPersonaje("perro", 0);
            }
            pantalla = 3;
        } else if (pantalla == 3) {
            if (vertical == 7 && horizontal == 2) {
                int rnd = getDado();
                ui.mostrarDado(rnd); //mostarra resultado dado
                jugador1.avanzar(rnd);
            }
        } else if (pantalla == 4) {
            ui.instrucciones();
            pantalla = 1;
        } else if (pantalla == 5) {
            ui.instrucciones();
            pantalla = 1;
        } else {
            throw new NumeroDePantallaIncorrectoException();
        }
    }

    public void actualizarCasilla(int posicion) {
        String imagen = "";
        if (jugador1.getPosicion() == posicion) {
            imagen = jugador1.getImagen();
            ui.dibujarPersonaje(imagen, posicion);
        } else {
            imagen = "negro";
            ui.borarrPersonaje(posicion);
        }

    }

    public void victoria() {
        ui.ganar();
        pantalla = 4;
    }

    public void perder() {
        ui.perder();
        pantalla = 5;
    }

    public void jugadorLlegaACasilla(int posicion) {
            casillas.get(posicion).efecto(jugador1);
    }

    //public void eleccionCarta()

    public void actualizarVida(int vida) {
        ui.actualizarVida(vida);
    }

    public void mostrarTexto(String mensaje) {
        ui.mostrarTextito(mensaje);
    }

    public void cartaFortuna() {
        Carta cartaFortuna = lf.poll();
        ui.mostrarTextoFortuna(cartaFortuna.getMensajeCartas());
        cartaFortuna.efecto(jugador1);
        lf.offer(cartaFortuna);
    }

    public void cartaCastigo() {
        Carta cartaCastigo = lc.poll();
        ui.mostrarTextoCastigo(cartaCastigo.getMensajeCartas());
        cartaCastigo.efecto(jugador1);
        lf.offer(cartaCastigo);
    }

}