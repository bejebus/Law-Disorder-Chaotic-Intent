/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.creatures;

import com.leonesoft.chaos.pieces.Piece;

/**
 *
 * @author Pete
 */
public abstract class Creature extends Piece {
    
      
    private boolean alive;
    private boolean undead;

    void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isUndead() {
        return undead;
    }

    void setUndead(boolean undead) {
        this.undead = undead;
    }
    
}
