/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Painter;
import java.awt.Point;

/**
 *
 * @author godievski
 */
public class Avatar extends Entity{
    public static final int INIT_DIR = 0;
    public static final int UP_DIR = 1;
    public static final int DOWN_DIR = 2;
    public static final int LEFT_DIR = 3;
    public static final int RIGHT_DIR = 4;
    
    public static final String COLOR_AVATAR = Painter.ANSI_YELLOW;
    public static final int HPMAX = 10;
  
    private Bag bag;
    private int hp;
    private Armor armor;
    private Weapon weapon;
    
    private int direction;
    
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
        this.direction = INIT_DIR;
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
    /*ACTIONS*/
    public void move(Map map,char dir){
        int x_fin = this.x;
        int y_fin = this.y;
        int final_dir = this.direction;
        if (dir == 'A'){
            x_fin--;
            final_dir = LEFT_DIR;
        }
        else if(dir =='W'){
            y_fin--;
            final_dir = UP_DIR;
        }
        else if(dir=='S'){
            y_fin++;
            final_dir = DOWN_DIR;
        }
        else if(dir=='D'){
            x_fin++;
            final_dir = RIGHT_DIR;
        }
        Cell cell = map.getCell(y_fin, x_fin);
        if(cell != null){
            if (cell.getType() != Cell.WALL && cell.getEnemy() == null){
                this.x = x_fin;
                this.y = y_fin;
            }
        }
        this.direction = final_dir;
    }
    
    public boolean attack(){
        return true;
    }
    
    public void pickUpArtefact(Map map){
        Cell cell;
        Point position_fin = this.getDirectionPos();
        cell = map.getCell(position_fin.y, position_fin.x);
        if (cell != null){
            Artefact artefact = cell.getArtefact();
            if (artefact != null){
                this.bag.addArtefact(artefact);
                cell.setArtefact(null);
                return;
            }
        }
        cell = map.getCell(this.y, this.x);
        if (cell != null){
            Artefact artefact = cell.getArtefact();
            if (artefact != null){
                this.bag.addArtefact(artefact);
                cell.setArtefact(null);
            }
        }
    }
    public int getDirection(){
        return this.direction;
    }
    
    public Point getDirectionPos(){
        int x_fin = this.x;
        int y_fin = this.y;
        if(this.direction == LEFT_DIR)
            x_fin--;
        else if(this.direction == RIGHT_DIR)
            x_fin++;
        else if(this.direction == UP_DIR)
            y_fin--;
        else if(this.direction == DOWN_DIR)
            y_fin++;
        return new Point(x_fin,y_fin);
    }
    
}