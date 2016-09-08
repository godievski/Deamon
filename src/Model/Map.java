/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MngEnemy;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author godievski
 */
public class Map {
    public static int MAX_L_ENEMY = 4;
    
    private Cell[][] cells;
    private int length;
    private int width;
    private double prob_enemy;
    private double prob_artefact;
    private int[] level_enemy;
    private Point prev_pos;
    private Point next_pos;
    
    public Map(int length, int width, int level){
        Random rnd = new Random();
        this.length = 2*length+1;
        this.width = 2*width+1;
        this.cells = new Cell[this.width][this.length];
        for(int i = 0; i < this.width; i++)
            for(int j = 0; j < this.length; j++)
                this.cells[i][j] = new Cell(j,i);
        this.prob_enemy = rnd.nextDouble() / 10;
        this.prob_artefact = rnd.nextDouble() / 10;
        
        this.level_enemy = new int[MAX_L_ENEMY];
        for(int i = 1; i <= MAX_L_ENEMY; i++)
            this.level_enemy[i-1] = level + i;
    }
    
    public double getProbArtefact(){
        return this.prob_artefact;
    }
    public double getProbEnemy(){
        return this.prob_enemy;
    }
    public int getLevelEnemy(int index){
        return this.level_enemy[index];
    }
    
    public Cell getCell(int i, int j){
        return this.cells[i][j];
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public Cell getAdjacent(int i, int j){
        Cell[] cellsAround = new Cell[4];
        if (i+2 < this.width)
            cellsAround[0] = this.cells[i + 2][j];
        if (i-2 >= 0) 
            cellsAround[1] = this.cells[i - 2][j];
        if (j+2 < this.length)
            cellsAround[2] = this.cells[i][j + 2];
        if (j - 2 >= 0)
            cellsAround[3] = this.cells[i][j - 2];
        Vector<Cell> cellsAd = new Vector();
        for(Cell cell: cellsAround){
                if (cell != null && cell.getType() == Cell.WALL){
                    cellsAd.add(cell);
                }
        }
        if(cellsAd.isEmpty())
            return null;
        else{
            Random rnd = new Random();
            int pos = rnd.nextInt(cellsAd.size());
            return cellsAd.get(pos);
        }
    }
    public void createPath(int i1, int j1, int i2, int j2){
        if(i1 == i2){
            int aux = j1;
            if(j1 > j2){
                aux = j1;
                j1 = j2;
                j2 = aux;
            }
            for(int x = j1; x <= j2; x++){
                Cell cell = this.cells[i1][x];
                cell.setType(Cell.IN);
                cell.setColor(Cell.COLOR_IN);
                cell.setImage(Cell.IMAGE_IN);
            }
        } else if (j1 == j2) {
            int aux = i1;
            if (i1 > i2){
                aux = i1;
                i1 = i2;
                i2 = aux;
            }
            for(int y = i1; y <=i2; y++){
                Cell cell = this.cells[y][j1];
                cell.setType(Cell.IN);
                cell.setColor(Cell.COLOR_IN);
                cell.setImage(Cell.IMAGE_IN);
            }
        } else {
            System.err.println("Error: Created Path function");
            System.exit(1);
        }
    }

    
    public Point getPrev_pos() {
        return prev_pos;
    }
    public void setPrev_pos(Point prev_pos) {
        this.prev_pos = prev_pos;
    }
    
    public Point getNext_pos() {
        return next_pos;
    }
    public void setNext_pos(Point next_pos) {
        this.next_pos = next_pos;
    }

}
