package edu.upb.lp.progra.upbPolio;

public class Carta extends ElementoConEfecto {
    //efecto de las cartas de fortunas y castigos

    private int ganancia;
    private String mensajeCartas;

    public Carta(UpbPolioGame game, int ganancia, String mensajeCartas) {
        super(game);
        this.ganancia = ganancia;
        this.mensajeCartas = mensajeCartas;
    }

    public String getMensajeCartas() {
        return mensajeCartas;
    }

    @Override
    public void efecto(Personaje jugador) { //el efecto de cada fortuna
        if (jugador.getPosicion() == 4 || jugador.getPosicion() == 13) {
            jugador.potenciador(ganancia);
        } else if (jugador.getPosicion() == 2 || jugador.getPosicion() == 12) {
            jugador.potenciador(ganancia);
        }
    }
}
