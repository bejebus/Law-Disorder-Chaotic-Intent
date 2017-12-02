/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.hexengine;

import com.leonesoft.chaos.map.Tile;
import com.igormaznitsa.jhexed.engine.HexEngine;
import com.igormaznitsa.jhexed.engine.HexEngineModel;
import com.igormaznitsa.jhexed.engine.misc.HexPosition;
import java.util.Arrays;

/**
 *
 * @author Pete
 */
public class ChaosTileModel  implements HexEngineModel<Tile> {

    private int columns;
    private int rows;
    private Tile outOfBoundsValue;
    private Tile[] map;
     

    public ChaosTileModel(int columns, int rows, Tile outOfBoundsValue) {
        if (columns <= 0) {
          throw new IllegalArgumentException("Column number must be greater than zero [" + columns + ']');
        }
        if (rows <= 0) {
          throw new IllegalArgumentException("Row number must be greater than zero [" + rows + ']');
        }

        this.columns = columns;
        this.rows = rows;
        this.outOfBoundsValue = outOfBoundsValue;
        this.map = new Tile[rows * columns];
        Tile defaultTile = Tile.createVoidTile();
        for(int i = 0; i < map.length; i++) {
            map[i] = defaultTile;
        }
    }

    public Tile[] getMap() {
        return Arrays.copyOf(map, map.length);
    }

    public void setMap(final Tile[] map) {
        this.map = Arrays.copyOf(map, rows * columns);
    }
    
    

    @Override
    public int getColumnNumber() {
        return columns;
    }

    @Override
    public int getRowNumber() {
        return rows;
    }
    
    private int getIndex(int x, int y) {
        return y + x * columns;
    }

    @Override
    public Tile getValueAt(int x, int y) {
        if(isPositionValid(x, y))
            return map[getIndex(x, y)];
        return outOfBoundsValue;
    }

    @Override
    public Tile getValueAt(HexPosition hp) {
        return getValueAt(hp.getColumn(), hp.getRow());
    }

    @Override
    public void setValueAt(int x, int y, Tile e) {
        int index = getIndex(x, y);
        map[index] = e;
    }

    @Override
    public void setValueAt(HexPosition hp, Tile e) {
        setValueAt(hp.getColumn(), hp.getRow(), e);
    }

    @Override
    public boolean isPositionValid(int x, int y) {
        return (x > -1 && x < rows && y > -1 && y < columns);
    }

    @Override
    public boolean isPositionValid(HexPosition hp) {
        return isPositionValid(hp.getRow(), hp.getRow());
    }

    @Override
    public void attachedToEngine(HexEngine<?> he) {
        
    }

    @Override
    public void detachedFromEngine(HexEngine<?> he) {
        
    }
    
}
