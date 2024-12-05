package edu.upb.lp.progra.superMegaJuego;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class SuperMegaJuegoUI implements UI {
    private AndroidGameGUI gui;
    //private SuperMegaJuegoGame ui = new SuperMegaJuegoGame(this);

    public SuperMegaJuegoUI (AndroidGameGUI gui){
        this.gui = gui;
    }

    @Override
    public void onButtonPressed(String name) {
      /*  if (name.equals("Reset")){
            for(int v = 0; v < 3; v++){
                for(int h = 0; h < 3; h++){
                    gui.setImageOnCell(v, h, "colors_grey");
                }
            }
        }*/
    }

    @Override
    public void onCellPressed(int vertical, int horizontal) {
      //ui.clic(vertical, horizontal);
      gui.showTemporaryMessage("Vamonos");
    }

    @Override
    public void initialiseInterface() {
        gui.configureScreen(3,3,2,2, true, 0.3);
        for(int v = 0 ; v < 3 ; v++){
            for(int h = 0 ; h < 3 ; h++){
                gui.setImageOnCell(v, h, "colors_grey");
            }
        }
       // gui.addButton("Reset", 20, 40);
    }

   // public void ponerCasillaAzul(int vertical, int horizontal) {
     //   gui.setImageOnCell(vertical, horizontal, "colors_blue");
    //}
}
