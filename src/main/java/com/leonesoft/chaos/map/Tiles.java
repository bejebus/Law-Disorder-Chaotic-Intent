/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.map;

/**
 *
 * @author Pete
 */
public enum Tiles {
    GRASS,
    PAVING,
    VOID;
    
    public static void incrementHeight(Tile tile) {
        if (tile.getType() != Tiles.VOID) {

            short height = (short) (tile.getHeight() + 1);
            if(height > Tile.MAX_HEIGHT)
                height = Tile.MIN_HEIGHT;
            tile.setHeight(height);
        }
    }
}
