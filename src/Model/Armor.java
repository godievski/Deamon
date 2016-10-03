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
public class Armor extends Artefact {
    private static final int DEF_BASE = 10;
    private static final int HP_PLUS_BASE = 0;
    
    private int def;
    private int hp_plus;
    
    public Armor(String name, int level) {
        super(name, level);
        this.def = DEF_BASE;
        this.hp_plus = HP_PLUS_BASE;
    }

    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getHpPlus(){
        return this.hp_plus;
    }
    public void setHpPlus(int hp){
        this.hp_plus = hp;
    }

}
