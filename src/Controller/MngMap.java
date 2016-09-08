/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cell;
import Model.Map;
import java.awt.Point;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author godievski
 */
public class MngMap {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    
    private static int MAX = 30;
    private static int MIN = 20;
    
    private Map[] maps;
    private int levels;
    
    public MngMap(int levels){
        Random rnd = new Random();
        this.levels = levels;
        this.maps = new Map[levels];
        for(int i = 0; i < levels; i++){
            int length = MIN + rnd.nextInt(MAX-MIN);
            int width = MIN + rnd.nextInt(MAX-MIN);
            this.maps[i] = generateMap(length,width,i);
            this.setPrevNext(i);
        }
            
    }
    
    public Map getMap(int level){
        return this.maps[level];
    }
    
    private void setPrevNext(int level){
        Random rnd = new Random();
        Map map = this.maps[level];
        int w = (map.getWidth() - 1) / 2;
        /*PREV*/
        int posPrev_x = 1;
        int posPrev_y = rnd.nextInt(w) * 2 + 1;
        Cell cell = map.getCell(posPrev_y,posPrev_x);
        cell.setType(Cell.PREV);
        cell.setColor(Cell.COLOR_PREV);
        cell.setImage(Cell.IMAGE_PREV);
        map.setPrev_pos(new Point(posPrev_x,posPrev_y));
        
        /*NEXT*/
        int posNext_x = map.getLength() - 2;
        int posNext_y = rnd.nextInt(w) * 2 + 1;
        Cell cell2 = map.getCell(posNext_y,posNext_x);
        cell2.setType(Cell.NEXT);
        cell2.setColor(Cell.COLOR_NEXT);
        cell2.setImage(Cell.IMAGE_NEXT);
        map.setNext_pos(new Point(posNext_x,posNext_y));
    }

    private Map generateMap(int length, int width, int level){
        Scanner reader = new Scanner(System.in);
        
        Random rnd = new Random();
        Map map = new Map(length, width, level);
        Stack<Cell> stackCell = new Stack();
        int i = rnd.nextInt(width)*2 + 1;
        int j = rnd.nextInt(length)*2 + 1;
        
        Cell cellTemp = map.getCell(i, j);
        cellTemp.setType(Cell.IN);
        stackCell.push(cellTemp);
        while(!stackCell.empty()){
            Cell cell = stackCell.peek();
            Cell cellAd;
            /*getY == i && getX == j*/
            if ((cellAd=map.getAdjacent(cell.getY(),cell.getX())) != null){
                map.createPath(cell.getY(),cell.getX(),cellAd.getY(),cellAd.getX());
                stackCell.push(cellAd);
            } else
                stackCell.pop();
        }
        return map;
    }
    
    public Point getPrevPosition(int level){
        return this.maps[level].getPrev_pos();
    }
    
    public Point getNextPosition(int level){
        return this.maps[level].getNext_pos();
    }
    
    public void printMap(int level){
        Map map = this.maps[level];
        for(int i = 0; i < map.getWidth();i++){
            for(int j = 0; j < map.getLength(); j++){
                Cell cell = map.getCell(i, j);
                int cellType = cell.getType();
                if(cellType == Cell.WALL)   
                    System.out.print(ANSI_RED+"\u2588"+ANSI_RESET);
                else if(cellType == Cell.IN){
                    if(cell.getEnemy() != null){
                        System.out.print("O");
                    } else if(cell.getArtefact() != null){
                        System.out.print("X");
                    } else 
                    System.out.print(" ");
                }
                else if(cellType == Cell.PREV)
                    System.out.print("P");
                else if(cellType == Cell.NEXT)
                    System.out.print("N");
            }
            System.out.println();
        }
    }
    public void printMap(Map map){
        for(int i = 0; i < map.getWidth();i++){
            for(int j = 0; j < map.getLength(); j++){
                Cell cell = map.getCell(i, j);
                int cellType = cell.getType();
                if(cellType == Cell.WALL)   
                    System.out.print(ANSI_RED+"\u2588"+ANSI_RESET);
                else if(cellType == Cell.IN){
                    if(cell.getEnemy() != null){
                        System.out.print("O");
                    } else if(cell.getArtefact() != null){
                        System.out.print("X");
                    } else 
                    System.out.print(" ");
                }
                else if(cellType == Cell.PREV)
                    System.out.print("P");
                else if(cellType == Cell.NEXT)
                    System.out.print("N");
            }
            System.out.println();
        }
    }
    
}
