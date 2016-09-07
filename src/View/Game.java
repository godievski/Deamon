/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MngMap;

/**
 *
 * @author godievski
 */
public class Game {
    private static final int MAX_LEVEL_DEF = 10;
    private MngMap mngMap;
    
    public Game(){
        this.mngMap = new MngMap(MAX_LEVEL_DEF);
    }
}
