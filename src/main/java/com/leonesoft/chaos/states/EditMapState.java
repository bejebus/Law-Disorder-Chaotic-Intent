/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.states;

import com.igormaznitsa.jhexed.engine.HexEngine;
import com.igormaznitsa.jhexed.engine.HexEngineModel;
import com.leonesoft.chaos.Chaos;
import com.leonesoft.chaos.gui.TextField;
import com.leonesoft.chaos.hexengine.ChaosHexRender;
import com.leonesoft.chaos.hexengine.ChaosTileModel;
import com.leonesoft.chaos.map.Tile;
import com.leonesoft.chaos.map.Tiles;
import de.matthiasmann.twl.Label;
import de.matthiasmann.twl.ToggleButton;
import de.matthiasmann.twl.ValueAdjusterInt;

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.state.StateBasedGame;


/**
 *
 * @author Pete
 */
public class EditMapState extends ChaosBasicGameState {
    
    
        

    final HexEngine<Graphics> eng = new HexEngine<>(32, 32, HexEngine.ORIENTATION_VERTICAL);
    // final Database database;
    final Point hexOffset = new Point(25f, 25f);
    // final Font font = new UnicodeFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 14));
    private Font font = null;   

    List<String> editorNames = new ArrayList<>();
    
    int xClick = -1;
    int yClick = -1;

    String mapNamePlaceholderText = "Map Name";
        
    Random rng = Chaos.getRng();
    private String editorName;
    Label label = new Label();
    ValueAdjusterInt rowsField = new ValueAdjusterInt();
    ToggleButton checkBox = new ToggleButton();

    @Override
    public void mouseClicked(final int button, final int x, final int y, final int clickCount) {
        
        xClick = x;
        yClick = y;
        
        HexEngineModel<Tile> model = (HexEngineModel<Tile>) eng.getModel();
        

        int xHex = (int) (x - hexOffset.getX());
        int yHex = (int) (y - hexOffset.getY());

        int row = eng.calculateRow(xHex, yHex);
        int col = eng.calculateColumn(xHex, yHex);

        if (model.isPositionValid(col, row)) {

            Tile currentTile = model.getValueAt(col, row);

            switch (button) {
                case 0: // add grass
                    if(currentTile.getType() == Tiles.VOID) {
                        currentTile = Tile.createGrassTile();
                        model.setValueAt(col, row, currentTile);
                    } else
                        Tiles.incrementHeight(currentTile);
                   
                    break;
                case 1: // remove grass
                    model.setValueAt(col, row, Tile.createVoidTile());
                    break;
            }
            return;
        }
        
               
    }
    
    private Rectangle fieldBounds(final TextField field) {
        return new Rectangle(field.getX(), field.getY(), field.getWidth(), field.getHeight());
    }
    
    private boolean fieldContains(final TextField field, final float x, final float y) {
        Rectangle r = fieldBounds(field);
        return r.contains(x, y);
    }

    @Override
    public int getID() {
        return States.MapEditor.hashCode();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        java.awt.Font[] fonts = e.getAllFonts(); // Get the fonts
        
        java.awt.Font font1 = fonts[rng.nextInt(fonts.length)];
        java.awt.Font font2 = font1.deriveFont(java.awt.Font.PLAIN, 14f);
        UnicodeFont f = new UnicodeFont(font2);
        f.getEffects().add(new ColorEffect(java.awt.Color.white));
        f.addAsciiGlyphs();
        f.loadGlyphs();
        
        gc.setDefaultFont(f);
        
        font = gc.getDefaultFont();
        
        ChaosHexRender chaosHexRender = new ChaosHexRender();
        eng.setRenderer(chaosHexRender);
        HexEngineModel<?> model = new ChaosTileModel(20, 20, Tile.createVoidTile());
        eng.setModel(model);
        int columnNumber = model.getColumnNumber();
        float width = 32; // chaosHexRender.getHexPath().getWidth();
        
        editorNames.add("Map Editor");
        editorNames.add("Meditor");
        editorNames.add("Map Craft");
        editorNames.add("Maptastic");
        editorNames.add("Mapalalooza");
        editorNames.add("Mapsolutely Fabulous");
        editorNames.add("Mappy Chaosmas");
        editorNames.add("Mapsy-Daisy!");
        editorNames.add("Enter the Maptricks");
        
        editorName = editorNames.get(rng.nextInt(editorNames.size()));
        
        
       
        
    }
    
    @Override
    protected RootPane createRootPane() {
        RootPane rp = super.createRootPane();
        rp.setTheme("optionsdialog");
                
        
        
        rp.add(checkBox);
        //rp.add(label);
        //rp.add(rowsField);
        return rp;
    }

    @Override
    protected void layoutRootPane() {
        
        label.setTheme("label");
        
        label.setText("this is a label");
        label.setSize(200, 50);
        label.setPosition(700, 20);
        label.adjustSize();
        
        rowsField.adjustSize();
        rowsField.setTheme("valueadjuster");
        rowsField.setPosition(700, 50);
        rowsField.setSize(200, 50);
        rowsField.setMinMaxValue(0, 100);
        rowsField.adjustSize();
        
        checkBox.setSize(200, 50);
        checkBox.setText("Check this out");
        checkBox.setTheme("checkmark");
        
        getRootPane().setPosition(700, 20);
        getRootPane().adjustSize();
    }
    
        

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        
        g.setFont(font);
        g.setColor(Color.yellow);
        g.drawString(editorName, 3, 1);
        String fontName = ((UnicodeFont) font).getFont().getFontName();
        g.setColor(Color.white);
        g.drawString(fontName, font.getWidth(editorName) + 10, 1);
        drawHexEngine(g);
        g.setColor(Color.yellow);
       
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //getRootPane().getGUI().update();
    }
    
    private void drawHexEngine(Graphics g) {
        g.translate(hexOffset.getX(), hexOffset.getY());
        eng.draw(g);
        g.translate(-hexOffset.getX(), -hexOffset.getY());
    }

}
