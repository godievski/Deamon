/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Painter;
import java.util.Random;

/**
 *
 * @author godievski
 */
public class Artefact extends Sprite{
    public static final String IMAGE_DEF = "\u25B4";
    public static final String COLOR_DEF = Painter.ANSI_RED;
    public static final double PROB_DEF = 1;
    public static final int MIN_LEVEL_DEF = 0;
    
    private String name;
    private int nivel;
    private double prob;
    
    
    public Artefact(String name){
        super(IMAGE_DEF,COLOR_DEF);
        Random rnd = new Random();
        this.name = name;
        this.prob = rnd.nextDouble() / 10;
        this.nivel = MIN_LEVEL_DEF;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getProb(){
        return this.prob;
    }
}
