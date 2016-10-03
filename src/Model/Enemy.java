/*
 * To change this license header, choose License Headers in Project Properties.
 * Tw
w
w
w
d
so change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Painter;
import java.util.Random;

/**
 *
 * @author godievski
 */
public class Enemy extends Entity{
    public static final String COLOR_ENEMY = Painter.ANSI_GREEN;
    private static final Random rnd = new Random();
    private static final int LEVEL_DEF = 1;
    private static final int HP_BASE = 20;
    
    private int level;
    private int attack;
    private int armor;
    
    public Enemy() {
        super(HP_BASE);
        this.setColor(COLOR_ENEMY);
    }
    public Enemy(int x, int y, int level) {
        super(x,y, HP_BASE);
        this.setColor(COLOR_ENEMY);
        this.level = level;
    }
    
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getAttack(){
        return this.attack;
    }
    public int getArmor(){
        return this.armor;
    }
    
    public void attackedBy(int points){
        //TODO
    }
    
    private int generateHPByLvl(int level){
        return (int)(HP_BASE * ( 1 + rnd.nextDouble()));
    }
    
    
}
