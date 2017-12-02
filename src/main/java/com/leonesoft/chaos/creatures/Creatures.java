/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.creatures;

/**
 *
 * @author Pete
 */
public class Creatures {
    
    static void kill(Creature c) {
        if(c.isAlive()) {
            c.setAlive(false);
        }
    }
    
    static void raise(Creature c) {
        if(!c.isAlive()) {
            c.setAlive(true);
            c.setUndead(true);
        }
    }
}
