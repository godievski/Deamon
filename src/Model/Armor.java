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
    private static final int DEF_DEFAULT = 10;
    
    private int def;
    
    public Armor(String name) {
        super(name);
        this.def = DEF_DEFAULT;
    }
    public Armor(String name, int def){
        super(name);
        this.def = def;
    }

    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    
    
}
