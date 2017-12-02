/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.music;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;

/**
 *
 * @author Pete
 */
public class ChaosMusicListener implements MusicListener {

    PlayList playList;
    
    public ChaosMusicListener(PlayList playList) {
        this.playList = playList;
    }

    @Override
    public void musicEnded(Music music) {
        if(music != null) {
            music.removeListener(this);
        }
        playList.next();
    }

    @Override
    public void musicSwapped(Music music, Music newMusic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
