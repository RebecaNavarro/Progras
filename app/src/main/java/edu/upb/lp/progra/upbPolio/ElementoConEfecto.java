package edu.upb.lp.progra.upbPolio;

public abstract class ElementoConEfecto {

    private UpbPolioGame game;

    public ElementoConEfecto(UpbPolioGame game) {
        this.game = game;
    }

    public UpbPolioGame getGame() {
        return game;
    }

    public abstract void efecto(Personaje jugador);

}
