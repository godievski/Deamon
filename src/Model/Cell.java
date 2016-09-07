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



public class Cell {
    /*constants*/
    public static int WALL = 0;
    public static int IN = 1;
    public static int PREV = 2;
    public static int NEXT = 3;

    /*members*/
    private int type;
    private int x;
    private int y;
    
    /*reference to enemy*/
    private Enemy enemy;
    private Artefact artefact;
    
    public Cell(int x, int y){
        this.type = WALL;
        this.x = x;
        this.y = y;
        this.artefact = null;
        this.enemy = null;
    }
    
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type = type;
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

    public Enemy getEnemy() {
        return enemy;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    
    public Artefact getArtefact() {
        return artefact;
    }
    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }
    
}
