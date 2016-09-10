/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Painter;

/**
 *
 * @author godievski
 */
public class Entity extends Sprite{
    /*constants*/
    private static final int X_DEF = 1;
    private static final int Y_DEF = 1;
    public static final String IMAGE_DEF = "\u25CF";
    public static final String COLOR_DEF = Painter.ANSI_YELLOW;
      
    
    protected int x;
    protected int y;   
    /*for future
    private double x_ext;
    private double y_ext;
    */
    
    public Entity(){
        super(IMAGE_DEF,COLOR_DEF);
        this.x = X_DEF;
        this.y = Y_DEF;
    }
    
    public Entity(int x, int y){
        super(IMAGE_DEF,COLOR_DEF);
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
