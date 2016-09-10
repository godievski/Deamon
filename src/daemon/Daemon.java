/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon;

import Controller.MngMap;
import View.Game;

/**
 *
 * @author godievski
 */
public class Daemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //MngMap mngMap = new MngMap(2);
        //mngMap.printMap(0);
        Game game = new Game();
        game.play();
    }
    
}
