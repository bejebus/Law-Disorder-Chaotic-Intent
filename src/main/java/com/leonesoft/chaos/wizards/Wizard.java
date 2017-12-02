/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.wizards;

import com.leonesoft.chaos.equipments.Augment;
import com.leonesoft.chaos.equipments.Weapon;
import com.leonesoft.chaos.equipments.RangedWeapon;
import com.leonesoft.chaos.creatures.Creature;
import com.leonesoft.chaos.spells.Deck;
import com.leonesoft.chaos.spells.SpellCard;
import java.util.List;

/**
 *
 * @author Pete
 */
public class Wizard extends Creature {
        
    private Deck spells;
    private List<Augment> augments;
    private List<Weapon> weapons;
    private List<RangedWeapon> rangedWeapons;
    
    public List<? extends RangedWeapon> getRangedWeapons() {
        return rangedWeapons;
    }

    public List<? extends Augment> getAugments() {
        return augments;
    }
    
    public List<? extends Weapon> getWeapons() {
        return weapons;
    }

    public List<SpellCard> getSpells() {
        return spells.toList();
    }

}
