/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.limbo;

import com.leonesoft.chaos.creatures.Creature;
import com.leonesoft.chaos.pieces.Piece;
import java.util.Stack;

/**
 *
 * @author Pete
 */
public class Hex {
    int height;
    Stack<Piece> pieces;
    
    public boolean hasPiece() {
        if(pieces.isEmpty())
            return false;
        Piece p = pieces.peek();
        if(p instanceof Creature)
            return ((Creature) p).isAlive();
        return true;
    }
    
}
