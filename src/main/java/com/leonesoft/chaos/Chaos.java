/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos;

import com.leonesoft.chaos.music.PlayList;
import com.leonesoft.chaos.states.ChaosStateBasedGame;
import com.leonesoft.chaos.states.EditMapState;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Pete
 */
public class Chaos extends ChaosStateBasedGame {

    private static final Random rng = new Random();
    
    public static Random getRng() {
        return rng;
    }
    
    PlayList playList = new PlayList();

    public Chaos(String gamename) {
        super(gamename);
        playList.init();
        playList.next();
    }

    public static void main(String[] args) throws SlickException {
        
        AppGameContainer appgc;
        try {   
            appgc = new AppGameContainer(new Chaos("Law & Disorder: Chaotic Intent in Line of Sight"));
            appgc.setDisplayMode(1024, 768, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(Chaos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new EditMapState());
        
    }

    @Override
    protected URL getThemeURL() {
        try {
            return new URL("file:///C:/Users/Pete/Documents/NetBeansProjects/chaos/src/main/resources/themes/guiTheme.xml");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Chaos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
