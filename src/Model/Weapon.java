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
    private static final int DAMAGE_MIN_BASE = 1;
    private static final int DAMAGE_MAX_BASE = 10;
    
    private int damage_min;
    private int damage_max;
    
    public Weapon(String name, int level) {
        super(name, level);
        this.damage_min = DAMAGE_MIN_BASE;
        this.damage_max = DAMAGE_MAX_BASE;
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
