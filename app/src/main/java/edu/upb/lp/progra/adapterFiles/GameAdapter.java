package edu.upb.lp.progra.adapterFiles;

import edu.upb.lp.progra.elMejorJuegoSuperMegaDivertido.ElMejorJuegoSuperMegaDivertidoUI;
import edu.upb.lp.progra.quidditch.QuidditchUI;
import edu.upb.lp.progra.upbPolio.UpbPolioUI;

/**
 * This class allows to select what UI will be used by the Android library.
 * 
 * @author Alexis Marechal
 * @author Alfredo Villalba
 */
public class GameAdapter {
	public static UI selectGame(AndroidGameGUI gui) {
		//return new SuperMegaJuegoUI(gui);
		return new UpbPolioUI(gui);
	}
}
