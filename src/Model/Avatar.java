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
public class Avatar extends Entity{
    public static final int HPMAX = 10;
  
    private Bag bag;
    private int hp;
    private Armor armor;
    private Weapon weapon;
    
    public Avatar() {
        super();
        this.bag = new Bag();
        this.hp = HPMAX;
        this.armor = new Armor("Armor 1");
        this.weapon = new Weapon("Weapon 1");
    }
    public Avatar(char symbol, int x, int y) {
        super(x,y);
        this.bag = new Bag();
        this.hp = HPMAX;
        this.armor = new Armor("Armor 1");
        this.weapon = new Weapon("Weapon 1");
    }
    
}
