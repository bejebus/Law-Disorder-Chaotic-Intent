/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.spells;

/**
 *
 * @author Pete
 */
public enum SpellCard {
   Disbelieve(0, 10, 20, true),
Meditate(0, 1, 0),
KingCobra(1, 10, 1),
DireWolf(-1, 9, 1),
Goblin(-1, 9, 1),
Crocodile(0, 8, 1),
Troll(-1, 6, 1),
Faun(-1, 8, 1),
Lion(1, 6, 1),
Elf(2, 7, 1),
Orc(-1, 10, 1),
Bear(1, 6, 1),
Gorilla(0, 7, 1),
Ogre(-1, 7, 1),
Hydra(-1, 5, 1),
GiantRat(0, 10, 1),
Giant(1, 4, 1),
Horse(1, 9, 1),
Unicorn(2, 6, 1),
Centaur(1, 7, 1),
Pegasus(2, 7, 1),
Gryphon(1, 6, 1),
Manticore(-1, 4, 1),
Bat(-1, 8, 1),
GreenDragon(-1, 2, 1),
RedDragon(-2, 1, 1),
GoldenDragon(2, 2, 1),
Harpy(-1, 7, 1),
Eagle(1, 7, 1),
Vampire(-2, 2, 1),
Ghost(-1, 5, 1),
Spectre(-1, 6, 1),
Wraith(-1, 6, 1),
Skeleton(-1, 7, 1),
Zombie(-1, 9, 1),
GooeyBlob(-1, 9, 6),
MagicFire(-1, 8, 6),
MagicWood(1, 8, 8),
ShadowWood(-1, 4, 8),
MagicCastle(1, 6, 8),
DarkCitadel(-1, 6, 8),
Wall(0, 8, 6),
MagicBolt(0, 10, 6),
Blind(-1, 10, 6),
Lightning(0, 10, 4),
MagicSleep(1, 10, 6),
Vengeance(-1, 8, 20),
Justice(1, 8, 20),
DarkPower(-2, 5, 20),
Decree(2, 5, 20),
MagicShield(1, 7, 0),
MagicArmour(1, 4, 0),
MagicSword(1, 4, 0),
MagicKnife(1, 7, 0),
MagicBow(1, 5, 0),
MagicWings(0, 5, 0),
Law1(2, 8, 0),
Law2(4, 6, 0),
Chaos1(-2, 8, 0),
Chaos2(-4, 6, 0),
ShadowForm(0, 8, 0),
Subversion(0, 10, 7),
Mutation(0, 10, 7),
RaiseDead(-1, 5, 4),
Turmoil(-1, 5, 0);

    private final int rating;
    private final int chance;
    private final int range;
    private final boolean permanent;
    
    SpellCard(int rating, int chance, int range) {
        this(rating, chance, range, false);      
    }

    SpellCard(int rating, int chance, int range, boolean permanent) {
        this.rating = rating;
        this.chance = chance;
        this.range = range;
        this.permanent = permanent;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public int getRating() {
        return rating;
    }

    public int getChance() {
        return chance;
    }

    public int getRange() {
        return range;
    }
    
    

}
