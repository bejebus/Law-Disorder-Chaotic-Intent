/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.challonge.api;

import com.exsoloscript.challonge.Challonge;
import com.exsoloscript.challonge.ChallongeApi;
import com.exsoloscript.challonge.ChallongeCredentials;

/**
 *
 * @author Pete
 */
public class Client {
    private static final String API_KEY = "E6t3zKpfL1xcPLqLVLgsFcnfltqeB1YDuxA4yNeo";
    private static final String USERNAME = "bejebu";
    
    private final ChallongeApi api = Challonge.getFor(USERNAME, API_KEY);
    
    Challonge index() {
        return null;
        
    }
}
