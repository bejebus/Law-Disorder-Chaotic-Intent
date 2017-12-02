/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

/**
 *
 * @author Pete
 */
public class RadioButtonGroup extends AbstractComponent {

    private int x, y, width, height;
    private List<RadioButton> boxes = new ArrayList<>();
    
    public RadioButtonGroup(GUIContext container, int x, int y, int width, int height) {
        super(container);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
       
    }

    public void add(RadioButton box) {
        Objects.requireNonNull(box);
        boxes.add(box);
        box.addListener((AbstractComponent source) -> {
            
            RadioButton b = (RadioButton) source;
            if(!b.isChecked())
                return;
            for(RadioButton other : boxes) {
                other.setChecked(false);
            }
            b.setChecked(true);
        });
    }

    @Override
    public void render(GUIContext container, Graphics g) throws SlickException {
        Rectangle bounds = new Rectangle(x, y, width, height);
        g.draw(bounds);
        int h = y;
        for (RadioButton box : boxes) {
            h += 2;
            box.setLocation(x + 2, h);
            box.render(container, g);
            h += box.getHeight();
        }
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
