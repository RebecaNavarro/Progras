package edu.upb.lp.progra.upbPolio;

public class CasCafe extends ElementoConEfecto {
    public CasCafe(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) {
        jugador.potenciador(10);
        jugador.mostrarMensaje("Micky te regaló una coca, subes 10 de estabilidad emocional :)");
    }
}
