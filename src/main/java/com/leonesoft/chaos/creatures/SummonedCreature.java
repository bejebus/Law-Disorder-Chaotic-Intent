/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.creatures;

import com.leonesoft.chaos.wizards.Wizard;

/**
 *
 * @author Pete
 */
public class SummonedCreature extends Creature {
    
    private Wizard owner;

    public Wizard getOwner() {
        return owner;
    }

    public void setOwner(Wizard owner) {
        this.owner = owner;
    }

     
    private boolean illusion;

    public boolean isIllusion() {
        return illusion;
    }

}
