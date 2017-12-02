/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.music;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import org.newdawn.slick.Music;
import java.util.Deque;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Pete
 */
public class PlayList {
    
    private final Deque<File> playList = new ArrayDeque<>();
    
    private final static float DEFAULT_VOLUME = 0.6f; // 60%
    
    private Music currentSong = null;
    private File currentFile = null;
    
    private final ChaosMusicListener listener = new ChaosMusicListener(this);
    private final FilenameFilter oggFilter = (File file, String string) -> string.endsWith(".ogg");
    
              
    public void init()  {
        File folder = new File("src/main/resources/music");
        List<File> list = Arrays.asList(folder.listFiles(oggFilter));
        Collections.shuffle(list);
        Collections.addAll(playList, (File[]) list.toArray());        
    }
    
    public void next() {
        if(currentFile != null) {
            playList.addLast(currentFile);
        }
               
        try {
            currentFile = playList.removeFirst();
            currentSong = new Music(currentFile.getAbsolutePath());
            currentSong.addListener(listener);
            
            currentSong.play();
            currentSong.setVolume(DEFAULT_VOLUME);
        } catch (SlickException ex) {
            Logger.getLogger(PlayList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
