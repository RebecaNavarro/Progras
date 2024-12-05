package edu.upb.lp.progra.upbPolio;

public class CasFortuna extends ElementoConEfecto {

    public CasFortuna(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) { //salga una fortuna
       getGame().cartaFortuna();
    }
}
