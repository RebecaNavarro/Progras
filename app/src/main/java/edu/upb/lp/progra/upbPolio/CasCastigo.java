package edu.upb.lp.progra.upbPolio;

public class CasCastigo extends ElementoConEfecto {

    public CasCastigo(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) { //salga una fortuna
        getGame().cartaCastigo();
    }
}
