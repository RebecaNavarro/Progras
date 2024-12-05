package edu.upb.lp.progra.upbPolio;

public class CasRetro extends ElementoConEfecto {

    private String mensaje;

    public CasRetro(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) {
        jugador.retroceder(10);
        jugador.mostrarMensaje("Retrocedes 10 espacios :(");
    }
}
