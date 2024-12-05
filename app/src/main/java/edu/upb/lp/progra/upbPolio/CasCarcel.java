package edu.upb.lp.progra.upbPolio;

public class CasCarcel extends ElementoConEfecto{

    public CasCarcel(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) {
        jugador.potenciador(-50);
        jugador.mostrarMensaje("Vas a la carcel, pierdes 50 de estabilidad emocional :(");
    }
}
