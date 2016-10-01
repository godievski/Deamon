/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Vector;

/**
 *
 * @author godievski
 */
public class Bag {
    Vector<Artefact> artefacts;
    
    public Bag(){
        this.artefacts = new Vector();
    }
    
    public Artefact getArtefact(int index){
        if(index < 0 && index > this.artefacts.size())
            return this.artefacts.get(index);
        else
            return null;
    }
    public void replaceArtefact(int index, Artefact artefact){
        this.artefacts.add(index, artefact);
    }
    public void addArtefact(Artefact artefact){
        this.artefacts.add(artefact);
    }
    public void removeArtefact(int index){
        this.artefacts.remove(this);
    }
    public void clear(){
        this.artefacts.clear();
    }
    public int size(){
        return this.artefacts.size();
    }
}
