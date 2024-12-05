package edu.upb.lp.progra.upbPolio;

public class CasBlanco extends ElementoConEfecto {

    public CasBlanco(UpbPolioGame game) {
        super(game);
    }

    @Override
    public void efecto(Personaje jugador) {
        if(jugador.getPosicion()==1 || jugador.getPosicion()==5 ||
                jugador.getPosicion()==7 || jugador.getPosicion()==9 ||
                jugador.getPosicion()==11 || jugador.getPosicion()==15 ||
                jugador.getPosicion()==17){

        }
    }


}
