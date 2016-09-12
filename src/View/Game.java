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
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author godievski
 */
public class Game {
    /*constants*/
    private static final int MAX_LEVEL_DEF = 2;
    private static final int LENGTH_VISIBLE = 15;
    private static final int WIDTH_VISIBLE = 15;
    Random rnd = new Random();
    Scanner scan = new Scanner(System.in);
    
    /*members*/
    private MngMap mngMap;
    private MngEnemy mngEnemy;
    private Painter painter;
    private Avatar avatar;
    private int level;
    private boolean result_attack;
    
    public Game(){
        this.mngMap = new MngMap(MAX_LEVEL_DEF);
        this.mngEnemy = new MngEnemy(MAX_LEVEL_DEF);
        this.painter = new Painter(LENGTH_VISIBLE,WIDTH_VISIBLE);
        this.avatar = new Avatar();
        this.initMaps();
        this.initAvatar();
    }
    
    private void reset(){
        this.level = 0;
        this.result_attack = false;
    }
    
    public void play(){
        this.reset();
        this.printInstructionMsg();
        while(true){
            this.printMap(this.level);
            this.readCmd();
            this.updateState();
        }
    }
    
    private void readCmd(){
        String string_cmd = scan.nextLine();
        if (string_cmd.length() > 0){
            char cmd = Character.toUpperCase(string_cmd.charAt(0));
            System.out.print(cmd + "-" + string_cmd);
            if (cmd == 'A' || cmd == 'S' || cmd == 'D' || cmd == 'W')
                this.avatar.move(this.mngMap.getMap(this.level),cmd);
            else if (cmd == 'C'){   
                /*Need to pass cell of the actual position*/
                result_attack = this.avatar.attack();
            }
            else if (cmd == 'V')
                this.avatar.pickUpArtefact(this.mngMap.getMap(level));
        }
    }
    
    private void updateState(){
        /*ENEMIES*/
        if (result_attack){
            Point attack_pos = avatar.getDirectionPos();
            Cell cell = this.mngMap.getMap(this.level).getCell(attack_pos.y, attack_pos.x);
            if (cell != null){
                cell.setEnemy(null);
                this.mngEnemy.deleteEnemy(attack_pos, level);
            }
            result_attack = false;
        }
        
        /*MAPS*/
        int x = avatar.getX();
        int y = avatar.getY();
        int type_cell = this.mngMap.getMap(this.level).getCell(y, x).getType();
        if(type_cell == Cell.PREV){
            if(this.level > 0){
                this.level--;
                Map map = this.mngMap.getMap(this.level);
                Point next_pos = map.getNext_pos();
                avatar.setX(next_pos.x);
                avatar.setY(next_pos.y);
                this.printMap(level);
            }
        } else if (type_cell == Cell.NEXT){
            if (this.level < MAX_LEVEL_DEF-1){
                this.level++;
                Map map = this.mngMap.getMap(this.level);
                Point prev_pos = map.getPrev_pos();
                avatar.setX(prev_pos.x);
                avatar.setY(prev_pos.y);
                this.printMap(level);
            }
        }
    }
    
    public void printMap(int level){
        /*clear screen before*/
        clearConsole();
        this.painter.paintGame(mngMap.getMap(level), avatar);
    }
    
    public void printInstructionMsg(){
        clearConsole();
        System.out.println("INSTRUCTIONS");
        System.out.println("==========================");
        System.out.println("MOVE: W-A-S-D");
        System.out.println("PICK-UP ARTEFACT: V");
        System.out.println("ATTACK: C");
        System.out.println("(PRESS ENTER TO CONTINUE...)");
        scan.nextLine();
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
    
    private static void clearConsole(){
        try{
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}
