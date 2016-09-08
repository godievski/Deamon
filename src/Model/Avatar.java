/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Painter;

/**
 *
 * @author godievski
 */
public class Avatar extends Entity{
    public static final String COLOR_AVATAR = Painter.ANSI_YELLOW;
    public static final int HPMAX = 10;
  
    private Bag bag;
    private int hp;
    private Armor armor;
    private Weapon weapon;
    
    public Avatar() {
        super();
        this.setColor(COLOR_AVATAR);
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

    public Artefact getArtefact(int index) {
        return this.bag.getArtefact(index);
    }
    public void addArtefact(Artefact artefact) {
        this.bag.addArtefact(artefact);
    }
    public void removeArtefact(int index){
        this.bag.removeArtefact(index);
    }
    public void clearBag(){
        this.bag.clear();
    }
    
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
}
