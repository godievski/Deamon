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
public class Potion extends Artefact{
    private static final int HP_BASE = 1;
    
    private int hp;
    
    public Potion(String name, int level) {
        super(name, level);
        this.hp = HP_BASE;
    }
    
    public int getHP(){
        return this.hp;
    }
    public void setHP(int hp){
        this.hp = hp;
    }
}
