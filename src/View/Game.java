/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MngEnemy;
import Controller.MngMap;
import Model.Armor;
import Model.Artefact;
import Model.Avatar;
import Model.Cell;
import Model.Enemy;
import Model.Map;
import Model.Potion;
import Model.Weapon;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author godievski
 */
public class Game {
    /*constants*/
    private static final int MAX_LEVEL_DEF = 10;
    private static final int LENGTH_VISIBLE = 15;
    private static final int WIDTH_VISIBLE = 15;
    Random rnd = new Random();
    
    /*members*/
    private MngMap mngMap;
    private MngEnemy mngEnemy;
    private Painter painter;
    private Avatar avatar;
    
    public Game(){
        this.mngMap = new MngMap(MAX_LEVEL_DEF);
        this.mngEnemy = new MngEnemy(MAX_LEVEL_DEF);
        this.painter = new Painter(LENGTH_VISIBLE,WIDTH_VISIBLE);
        this.avatar = new Avatar();
        this.initMaps();
        this.initAvatar();
    }
    
    public void printMap(int level){
        this.painter.paintGame(mngMap.getMap(level), avatar);
    }
    
    private void initMaps(){
        for(int i = 0; i < MAX_LEVEL_DEF;i ++){
            Map map = this.mngMap.getMap(i);
            this.generateEnemies(map, i);
            this.generateArtefact(map);
        }
    }
    private void initAvatar(){
        Point firstPos = this.mngMap.getPrevPosition(0);
        this.avatar.setY(firstPos.y);
        this.avatar.setX(firstPos.x);
        this.avatar.setHp(Avatar.HPMAX);
    }
    private void generateEnemies(Map map, int level){
        int l = map.getLength() - 1;
        int w = map.getWidth() - 1;
        for(int i = 1; i < w; i++){
            for(int j = 1; j < l; j++){
                Cell cell = map.getCell(i, j);
                if(cell.getType() == Cell.IN){
                    double prob = map.getProbEnemy();
                    double dec = rnd.nextDouble();
                    if (dec <= prob){
                        /*generate enemy*/
                        int random_level = rnd.nextInt(Map.MAX_L_ENEMY);
                        Enemy enemy = new Enemy(j,i,map.getLevelEnemy(random_level));
                        cell.setEnemy(enemy);
                        this.mngEnemy.addEnemy(enemy, level);
                    }
                }
            }
        }
    } 
    private void generateArtefact(Map map){
        int l = map.getLength() - 1;
        int w = map.getWidth() - 1;
        for(int i = 1; i < w; i++){
            for(int j = 1; j < l; j++){
                Cell cell = map.getCell(i, j);
                if(cell.getType() == Cell.IN){
                    double prob = map.getProbArtefact();
                    double dec = rnd.nextDouble();
                    if (dec <= prob){
                        /*generate artefact*/
                        Artefact artefact = randomArtefact();
                        cell.setArtefact(artefact);
                    }
                }
            }
        }
    }
    private Artefact randomArtefact(){
        int dec = rnd.nextInt(3);
        switch (dec) {
            case 0:
                return new Armor("Armor 1");
            case 1:
                return new Weapon("Weapon 1");
            case 2:
                return new Potion("Potion 1");
            default:
                break;
        }
        return null;
    }
}
