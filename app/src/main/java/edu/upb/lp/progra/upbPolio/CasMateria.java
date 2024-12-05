package edu.upb.lp.progra.upbPolio;

public class CasMateria extends ElementoConEfecto {

    private int costo;
    private String mensaje;

    public CasMateria(UpbPolioGame game, int costo, String mensaje) {
        super(game);
        this.costo = costo;
        this.mensaje = mensaje;
    }

    @Override
    public void efecto(Personaje jugador) {
        jugador.deprimirse(costo);
        jugador.mostrarMensaje(mensaje);
    }
}