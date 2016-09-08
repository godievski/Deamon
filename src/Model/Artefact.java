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
public class Artefact extends Sprite{
    public static final String IMAGE_DEF = "\u25B4";
    public static final String COLOR_DEF = Painter.ANSI_RED;
    
    private String name;
    
    public Artefact(String name){
        super(IMAGE_DEF,COLOR_DEF);
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}
