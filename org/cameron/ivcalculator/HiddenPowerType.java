/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cameron.ivcalculator;

/**
 * Type enumeration for the different types Hidden Power can be. Each enum has the
 * value for the value of each type according to the Hidden Power type formula.
 * @author Cameron Roe
 */
public enum HiddenPowerType {
    FIGHTING (0, "Fighting"),
    FLYING (1, "Flying"),
    POISON (2, "Poison"),
    GROUND (3, "Ground"),
    ROCK (4, "Rock"),
    BUG (5, "Bug"),
    GHOST (6, "Ghost"),
    STEEL (7, "Steel"),
    FIRE (8, "Fire"),
    WATER (9, "Water"),
    GRASS (10, "Grass"),
    ELECTRIC (11, "Electric"),
    PSYCHIC (12, "Psychic"),
    ICE (13, "Ice"),
    DRAGON (14, "Dragon"),
    DARK (15, "Dark");
    
    private int index;
    private String typeString;
    
    /**
     * Constructor. Argument explained below.
     * @param index The value that the HP type formula must output to have an HP of the specified type
     */
    HiddenPowerType(int index, String string) {
        this.index = index;
        this.typeString = string;
    }
    
    /**
     * Method to get the index for the specified type for HP.
     * @return The index for the specified type
     */
    int getIndex() {
        return index;
    }
    
    /**
     * Method to return the type of the Hidden Power as a String.
     * @return The type as a String.
     */
    String getTypeByString() {
        return typeString;
    }
}
