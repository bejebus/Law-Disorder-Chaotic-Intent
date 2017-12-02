/* 
 * Copyright 2014 Igor Maznitsa (http://www.igormaznitsa.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.leonesoft.chaos.hexengine;

import com.leonesoft.chaos.map.Tile;
import com.igormaznitsa.jhexed.engine.*;
import com.igormaznitsa.jhexed.engine.misc.HexPoint2D;
import com.igormaznitsa.jhexed.engine.renders.HexEngineRender;

import org.newdawn.slick.Color;
// import java.awt.*;
import org.newdawn.slick.Graphics;
// import java.awt.geom.Path2D;
import org.newdawn.slick.geom.Path;
import org.newdawn.slick.Font;

public class ChaosHexRender implements HexEngineRender<Graphics>, HexEngineListener {

  private Path hexPath;
  
  protected boolean antialias = true;
  
  private final static Color VOID_COLOUR = Color.darkGray;
  private final static Color GRASS_COLOUR = Color.decode("#299b23");
  private final static Color PAVING_COLOUR = Color.lightGray;
  private final static float COLOUR_VARIANCE_FACTOR = 20f;
  
  public ChaosHexRender() {}

  public void setAntialias(final boolean flag){
    this.antialias = flag;
  }
  
  public boolean isAntialias(){
    return this.antialias;
  }
  
  @Override
  public void detachedFromEngine(final HexEngine<?> engine) {
    engine.removeHexLayerListener(this);
  }
  
  

  
  @Override
  public void renderHexCell(final HexEngine<Graphics> engine, final Graphics g, final float x, final float y, int col, int row) {
    
    g.setAntiAlias(antialias);

    final int xoff = Math.round(x);
    final int yoff = Math.round(y);

    g.translate(xoff, yoff);
    try {
      final HexEngineModel<?> model = engine.getModel();
      final Color fillColor = getFillColor(model, col, row);
      final Color borderColor = getBorderColor(model, col, row);

      drawUnderBorder(engine, g, col, row, borderColor, fillColor);
      
      final Path theShape = getHexPath();
      if (theShape != null) {

        if (fillColor != null) {
          g.setColor(fillColor);
          g.fill(theShape);
        }
        if (borderColor != null) {
          //final Stroke theStroke = getStroke();
          //if (theStroke != null) {
          //  g.setStroke(theStroke);
         // }
          g.setColor(borderColor);
          g.draw(theShape);
        }
        
        float[] center = theShape.getCenter();
        Tile tile = (Tile) model.getValueAt(col, row);
        short height = tile.getHeight();
        if(height != 0) {
            String text = String.valueOf(height);
            Color c = fillColor;
            c = c.darker(0.1f);
            g.setColor(c);
            Font font = g.getFont();
            int w = font.getWidth(text) ;
            int h = font.getHeight(text) ;
            g.drawString(text, center[0] - w / 2, center[1] - h/2);
        }
        
      }
        
        
        
    }
    finally {
      g.translate(-xoff, -yoff);
    }
  }

  public void drawUnderBorder(final HexEngine<Graphics> engine, final Graphics g, final int col, final int row, final Color borderColor, final Color fillColor){
    
  }
  
  
  public Path getHexPath() {
    return this.hexPath;
  }

  //public Stroke getStroke() {
  //  return this.stroke;
  //}

  public Color getBorderColor(final HexEngineModel<?> model, final int col, final int row) {
    return getFillColor(model, col, row).darker(0.05f);
  }
  
  
  
  public Color getFillColor(final HexEngineModel<?> model, final int col, final int row) {
    Tile tile = (Tile) model.getValueAt(col, row);
    short height = tile.getHeight();
    float variance = Math.abs(height) / COLOUR_VARIANCE_FACTOR;
    Color c;
    switch(tile.getType()) {
        case GRASS:
            c = GRASS_COLOUR;
            break;
        case PAVING:
            c = PAVING_COLOUR;
            break;
        case VOID:
        default:   
            c = VOID_COLOUR;
    }
    if(height < 0) {
        return c.darker(variance);
    }
    if(height > 0) {
        return c.brighter(variance);
    }
    return c;
  }

  @Override
  public void onEngineReconfigured(final HexEngine<?> engine) {
    
    this.hexPath = getHexShapeAsPath(engine, true);
  }

  @Override
  public void onScaleFactorChanged(final HexEngine<?> engine, final float scaleX, final float scaleY) {
    onEngineReconfigured(engine);
  }

  public void detachedRenderer(HexEngine<Graphics> canvas) {
    canvas.removeHexLayerListener(this);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void attachedToEngine(final HexEngine<?> engine) {
    engine.addHexLayerListener(this);
    onEngineReconfigured(engine);
  }

  @Override
  public void onRenderChanged(final HexEngine<?> source, final HexEngineRender<?> oldRenderer, final HexEngineRender<?> newRenderer) {
  }

  @Override
  public void onModelChanged(final HexEngine<?> source, final HexEngineModel<?> oldModel, final HexEngineModel<?> newModel) {
  }
  
  private Path getHexShapeAsPath(final HexEngine<?> engine, final boolean allowScaling) {
    final HexPoint2D[] points = engine.getHexPoints();

    Path path;
    if (allowScaling){
      path = new Path(points[0].getX() * engine.getScaleX(), points[0].getY() * engine.getScaleY());
      path.lineTo(points[1].getX() * engine.getScaleX(), points[1].getY() * engine.getScaleY());
      path.lineTo(points[2].getX() * engine.getScaleX(), points[2].getY() * engine.getScaleY());
      path.lineTo(points[3].getX() * engine.getScaleX(), points[3].getY() * engine.getScaleY());
      path.lineTo(points[4].getX() * engine.getScaleX(), points[4].getY() * engine.getScaleY());
      path.lineTo(points[5].getX() * engine.getScaleX(), points[5].getY() * engine.getScaleY());
    }else{
      path = new Path(points[0].getX(), points[0].getY());
      path.lineTo(points[1].getX(), points[1].getY());
      path.lineTo(points[2].getX(), points[2].getY());
      path.lineTo(points[3].getX(), points[3].getY());
      path.lineTo(points[4].getX(), points[4].getY());
      path.lineTo(points[5].getX(), points[5].getY());
    }   
      
    path.close();
      

    return path;
  }

}
