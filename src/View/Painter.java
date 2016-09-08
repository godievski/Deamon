/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Artefact;
import Model.Avatar;
import Model.Cell;
import Model.Enemy;
import Model.Map;

/**
 *
 * @author godievski
 */
public class Painter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    /*members center point*/
    private int length;
    private int width;
    
    public Painter(int length, int width){
        this.length = length;
        this.width = width;
    }
    
    void paintGame(Map map,Avatar avatar){
        int xCenter = avatar.getX();
        int yCenter = avatar.getY();
        
        int iIni = yCenter - this.width;
        if (iIni < 0) iIni = 0;
        int iFin = yCenter + this.width;
        if (iFin > map.getWidth()) iFin = map.getWidth();
        
        int jIni = xCenter - this.length;
        if (jIni < 0) jIni = 0;
        int jFin = xCenter + this.length;
        if (jFin > map.getLength()) 
            jFin = map.getLength();
        String out = " ";
        for(int i = iIni; i < iFin; i++){
            for(int j = jIni; j < jFin; j++){
                /*NEED TO PAINT AVATAR*/
                if(i == avatar.getY() && j == avatar.getX()){
                    out = avatar.getColor() + avatar.getImage() + ANSI_RESET;
                } else {
                    Cell cell = map.getCell(i, j);
                    Enemy enemy = cell.getEnemy();
                    Artefact artefact = cell.getArtefact();
                    if(enemy != null)
                        out = enemy.getColor() + enemy.getImage() + ANSI_RESET;
                    else if (artefact != null)
                        out = artefact.getColor() + artefact.getImage() + ANSI_RESET;
                    else
                        out = cell.getColor() + cell.getImage() + ANSI_RESET;    
                }
                System.out.print(out);
            }
            System.out.println();
        }
    }
}
