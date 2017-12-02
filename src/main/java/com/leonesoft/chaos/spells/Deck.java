/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.spells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Pete
 */
public class Deck {
    final static Random rng = new Random();
    final Stack<SpellCard> stack = new Stack<>();
    final int size;
    
    
    Deck(int size, int handSize) {
       this.size = size;
    }
    
    void populate(int size) {
        SpellCard[] spells = SpellCard.values();
        while(stack.size() < size) {
            SpellCard s = spells[rng.nextInt(spells.length)];
            if(!s.isPermanent())
                stack.push(s);
        }
    }
    
    public SpellCard draw() {
        SpellCard s = stack.peek();
        if(!s.isPermanent()) stack.pop();
        return s;
    }
    
    public List<SpellCard> toList() {
        return Collections.unmodifiableList(stack);
    }
}
