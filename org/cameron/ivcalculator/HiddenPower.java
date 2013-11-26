/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cameron.ivcalculator;

/**
 * Class to calculate hidden power values based off a Pokemon's IVs.
 * @author Cameron Roe
 * @version dev
 */
public class HiddenPower {
    private HiddenPowerType type;
    private int power;
    private int[] ivs;
    
    public HiddenPower(int[] ivs) {
        this.ivs = new int[ivs.length];
        System.arraycopy(ivs, 0, this.ivs, 0, ivs.length);
        type = calculateType();
        power = calculatePower();
        
    }
    
    public HiddenPowerType calculateType() {
        /*
         * A bit of information about bits.
         * The bits are simply the value of the least significant bit of the integer.
         * bits[0] = HP
         * bits[1] = Atk
         * bits[2] = Def
         * bits[3] = SpAtk
         * bits[4] = SpDef
         * bits[5] = Speed
         */
        int[] bits = new int[ivs.length];
        for(int i = 0; i < bits.length; i++) {
            if((ivs[i] % 2) == 0) {
                bits[i] = 0;
            } else {
                bits[i] = 1;
            }
        }
        int hiddenPowerType = (int) Math.floor(((bits[0] + 
			(2 * bits[1]) + (4 * bits[2]) + (8 * bits[5]) + 
			(16 * bits[3]) + (32 * bits[4])) * 15) / 63);
        HiddenPowerType[] values = HiddenPowerType.values();
        return values[hiddenPowerType];
    }
    
    public int calculatePower() {
        /*
         * A bit of information about bits.
         * The bits are simply the value of the least significant bit of the integer.
         * bits[0] = HP
         * bits[1] = Atk
         * bits[2] = Def
         * bits[3] = SpAtk
         * bits[4] = SpDef
         * bits[5] = Speed
         */
        int[] bits = new int[ivs.length];
        for(int i = 0; i < bits.length; i++) {
            if(((ivs[i] % 4) == 3) || ((ivs[i] % 4) == 3)) {
                bits[i] = 1;
            } else {
                bits[i] = 0;
            }
        }
        int hiddenPowerDamage = (int) Math.floor((((bits[0] + 
			(2 * bits[1]) + (4 * bits[2]) + (8 * bits[5]) + 
			(16 * bits[3]) + (32 * bits[4])) * 40) / 63) + 30);
        return hiddenPowerDamage;
    }
    
    public int getPower() {
        return power;
    }
    
    public HiddenPowerType getType() {
        return type;
    }
}
