/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 *
 * @author Pete
 */
public class RadioButton extends AbstractComponent {
    
    protected boolean checked;

    public RadioButton(GUIContext container, String label, int x, int y, int width, int height) {
        this(container, label, x, y, width, height, false);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    protected int height, width, x, y;

    public RadioButton(GUIContext container) {
        this(container, "checkbox", 0, 0, 200, 25, false);
    }
    
    public RadioButton(GUIContext container, String label, int x, int y, int width, int height, boolean checked) {
        super(container);
        this.label = label;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.checked = checked;
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        Rectangle bound = new Rectangle(getX(), getY(), width, height);
        if(bound.contains(x, y)) {
            checked = true;
        }
        super.mouseClicked(button, x, y, clickCount);
        notifyListeners();
    }
    
    

    @Override
    public void render(GUIContext container, Graphics g) throws SlickException {
        int w, h = w = height - 2;
        Circle circle = new Circle(x + (h / 2f), y + (h / 2f), (h / 2f));
       
        g.setColor(Color.yellow);
        g.draw(circle);
        if(checked) {
            Circle circle1 = new Circle(circle.getCenterX(), circle.getCenterY(), circle.getRadius() - 3);
            g.fill(circle1);
        }
        g.setColor(Color.white);
        g.drawString(label, height + x + 3, y + 1);
    }
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
