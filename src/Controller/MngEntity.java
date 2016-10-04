/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entity;

/**
 *
 * @author godievski
 */
public class MngEntity {
    
    public MngEntity(){
        //nothing :)
    }
    
    public void attack(Entity attacker, Entity attacked){
        double dmgMultiplier = 1 - 0.06 * attacked.getArmor() / ( 1 + 0.06 * Math.abs(attacked.getArmor()) );
        attacked.decreaseHp((int) (dmgMultiplier * attacker.getAttack()));
    }
}
