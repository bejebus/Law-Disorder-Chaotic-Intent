/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.limbo;

import java.util.Arrays;

/**
 *
 * @author Pete
 */
public class Arena {
    
    Hex[] grid;
    
    public Arena(int x, int y) {
        grid = new Hex[x * y];
        Arrays.fill(grid, new Hex());
    }
    
    
}
