/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.creatures;

import com.leonesoft.chaos.wizards.Wizard;

/**
 *
 * @author Pete
 */
public interface Mountable {
    Wizard getRider();
    void setRider(Wizard wizard);
    boolean hasRider();
}
