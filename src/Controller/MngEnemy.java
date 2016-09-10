/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cell;
import Model.Enemy;
import Model.Map;
import java.awt.Point;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author godievski
 */
public class MngEnemy {    
    private int level;
    ArrayList<Enemy>[] enemies;
    
    public MngEnemy(int level){
        this.enemies = new ArrayList[level];
        this.level = level;
        for(int i=0;i<level;i++)
            this.enemies[i] = new ArrayList();
    }
    public Enemy getEnemy(int index,int level){
        return this.enemies[level].get(index);
    }
    public void addEnemy(Enemy enemy,int level){
        this.enemies[level].add(enemy);
    }
    public void deleteEnemy(int index, int level){
        this.enemies[level].remove(index);
    }
    public void deleteEnemy(Point position, int level){
        ArrayList<Enemy> listEnemy = enemies[level];
        for(int i = 0;i<listEnemy.size();i++){
            Enemy enemy = listEnemy.get(i);
            if (enemy.getX() == position.x && enemy.getY() == position.y){
                listEnemy.remove(i);
                break;
            }
        }
    }
    public void clearEnemies(int level){
        this.enemies[level].clear();
    }
    
}
