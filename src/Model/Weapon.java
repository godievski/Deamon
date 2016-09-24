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
public class Weapon extends Artefact{
    private static final int DAMAGE_MIN_DEF = 1;
    private static final int DAMAGE_MAX_DEF = 10;
    
    private int damage_min;
    private int damage_max;
    
    public Weapon(String name) {
        super(name);
        this.damage_min = DAMAGE_MIN_DEF;
        this.damage_max = DAMAGE_MAX_DEF;
    }
    
    public Weapon(String name, int min, int max){
        super(name);
        this.damage_max = max;
        this.damage_min = min;
    }

    public int getDamage_min() {
        return damage_min;
    }
    public void setDamage_min(int damage_min) {
        this.damage_min = damage_min;
    }

    public int getDamage_max() {
        return damage_max;
    }
    public void setDamage_max(int damage_max) {
        this.damage_max = damage_max;
    }
    
}
