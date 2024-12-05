package edu.upb.lp.progra.upbPolio;

public class CasBus extends ElementoConEfecto {

    public CasBus(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) {
        jugador.avanzar(3);
        jugador.mostrarMensaje("Don German te dio un ride, avanzas 3 casillas :)");
    }
}
