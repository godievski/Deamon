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
public class Enemy extends Entity{
    private static final int LEVEL_DEF = 1;
    
    private int level;
    
    public Enemy() {
        super();
    }
    public Enemy(int x, int y, int level) {
        super(x,y);
        this.level = level;
    }
    
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
