/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.map;

import java.io.Serializable;
import java.util.Random;
import org.newdawn.slick.Color;

/**
 *
 * @author Pete
 */
public final class  Tile {
    
    private Tiles type = Tiles.VOID;
    private short height = (short) 0;
    
    public final static short MAX_HEIGHT = 3;   
    public final static short MIN_HEIGHT = 0;  

    public Tiles getType() {
        return type;
    }

    public void setType(Tiles type) {
        this.type = type;
    }
    
    Tile(Tiles type, short height) {
        setType(type);        
        setHeight(height);
    }
    
    Tile(Tiles type) {
        this(type, (short) 0);
    }
   
    public short getHeight() {
        return height;
    }
   
    public void setHeight(short height) {
        if(height > MAX_HEIGHT || height < MIN_HEIGHT)
            throw new IllegalArgumentException(String.format("Tile height must be between %d and %d. Value given: %d", MIN_HEIGHT, MAX_HEIGHT, height));
        this.height = height;
    }
    
    public static Tile createGrassTile(short height) {
        return new Tile(Tiles.GRASS, height);
    }
    
    public static Tile createGrassTile() {
        return new Tile(Tiles.GRASS);
    }
    
    final static Tile VOID_TILE = new Tile(Tiles.VOID);
    
    public static Tile createVoidTile() {
        return VOID_TILE;
    }
    
    
}
