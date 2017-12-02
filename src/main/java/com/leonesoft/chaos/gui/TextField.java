/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.gui;

import java.util.Objects;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

/**
 *
 * @author Pete
 */
public class TextField extends org.newdawn.slick.gui.TextField {
    
    private String placeholderText = null;
    private final static String MAX_LENGTH_FORMAT_STRING = "Max length: %d";
    private boolean showPlaceholderText = true;
    
    private Color placeholderTextColor = Color.gray;
    
    private Validator<String> validator = new Validator<String>() {};

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        Objects.requireNonNull(validator);
        this.validator = validator;
    }


    public Color getPlaceholderTextColor() {
        return placeholderTextColor;
    }

    public void setPlaceholderTextColor(Color placeholderTextColor) {
        this.placeholderTextColor = placeholderTextColor;
    }
    
    public TextField(GUIContext container, Font font, int x, int y, int width, int height, ComponentListener listener) {
        super(container, font, x, y, width, height, listener);
    }

    public TextField(GUIContext container, Font font, int x, int y, int width, int height) {
        super(container, font, x, y, width, height);
    }

    public String getPlaceholderText() {
        return placeholderText;
    }

    public void setPlaceholderText(String placeholderText) {
        this.placeholderText = placeholderText;
    }
    
    public boolean isShowingPlaceholderText() {
        return showPlaceholderText;
    }
    

    public void setShowPlaceholderText(boolean showPlaceholderText) {
        this.showPlaceholderText = showPlaceholderText;
    }
    
        private boolean showMaxLength = true;

    public boolean showMaxLength() {
        return showMaxLength;
    }

    public void setShowMaxLength(boolean showMaxLength) {
        this.showMaxLength = showMaxLength;
    }
    
        private int maxLength = 255;

    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void setMaxLength(int maxLength) {
        if(maxLength < 0)
            maxLength = 0;
        this.maxLength = maxLength;
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        Rectangle box = new Rectangle(getX(), getY(), getWidth(), getHeight());
        if(box.contains(x, y)) {
            if(!hasFocus()) {
                setFocus(true);
                setCursorPos(getText().length());
            }
        }
        super.mouseClicked(button, x, y, clickCount); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isValid() {
        return validator.isValid(getText());
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        if(showPlaceholderText && placeholderText != null && this.getText().length() == 0) {
            g.setColor(placeholderTextColor);
            g.drawString(placeholderText, getX() + 3, getY() + 1);
        }
        if(showMaxLength) {
            final float SCALE = 0.5f;
            final float RESCALE = (1 / SCALE);
            int xs = (int) ((int)  (getX() + 3) * RESCALE);
            int ys = (int) ((getY() + getHeight() + 1) * RESCALE);
            g.scale(SCALE, SCALE);
            g.drawString(String.format(MAX_LENGTH_FORMAT_STRING, getMaxLength()), xs, ys);
            g.scale(RESCALE, RESCALE);
        }
        if(!isValid())
            g.setColor(Color.red);
        super.render(container, g); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
