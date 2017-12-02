/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.pieces;

/**
 *
 * @author Pete
 */
public abstract class Piece {
    
    private String name;
    private int combat;
    private int rangedCombat;
    private int range;
    private int defence;
    private int movementAllowance;
    private int magicResistance;
    private int manoeuvreRating;
    
    public int getMagicResistance() {
        return magicResistance;
    }

    public int getMovementAllowance() {
        return movementAllowance;
    }

    public int getManoeuvreRating() {
        return manoeuvreRating;
    }

    public int getDefence() {
        return defence;
    }

    public int getRange() {
        return range;
    }

    public int getRangedCombat() {
        return rangedCombat;
    }

    public int getCombat() {
        return combat;
    }
    
    public String getName() {
        return name;
    }
    
}
