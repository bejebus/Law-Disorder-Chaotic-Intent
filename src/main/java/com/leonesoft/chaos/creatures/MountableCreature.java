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
public class MountableCreature implements Mountable {
    
    Wizard rider;

    @Override
    public Wizard getRider() {
        return rider;
    }

    @Override
    public void setRider(Wizard wizard) {
        this.rider = wizard;
    }

    @Override
    public boolean hasRider() {
        return rider != null;
    }
}
