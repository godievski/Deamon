/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author godievski
 */
public class Entity {
    private static final int X_DEF = 1;
    private static final int Y_DEF = 1;
    
    private char symbol;
    private int x;
    private int y;
    /*for future
    private double x_ext;
    private double y_ext;
    */
    
    public Entity(char symbol){
        this.symbol = symbol;
        this.x = X_DEF;
        this.y = Y_DEF;
    }
    
    public Entity(char symbol,int x, int y){
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }
    
    public char getSymbol(){
        return this.symbol;
    }
    public void setSymbol(char symbol){
        this.symbol = symbol;
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
