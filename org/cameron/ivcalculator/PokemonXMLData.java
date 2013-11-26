/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cameron.ivcalculator;

/**
 * Container class for data held by the XML parsed for a Pokemon.
 * @author Cameron Roe
 * @version dev
 */
public class PokemonXMLData {
    private String name;
    private int pokedexNum, hp, atk, def, spAtk, spDef, speed;

    public PokemonXMLData(String name, String pokedexNum, String hp, String atk, String def, String spAtk, String spDef, String speed) {
        this.name = name;
        this.pokedexNum = Integer.parseInt(pokedexNum);
        this.hp = Integer.parseInt(hp);
        this.atk = Integer.parseInt(atk);
        this.def = Integer.parseInt(def);
        this.spAtk = Integer.parseInt(spAtk);
        this.spDef = Integer.parseInt(spDef);
        this.speed = Integer.parseInt(speed);
    }

    public String getPokemonName() {
        return name;
    }

    public int getPokedexNumber() {
        return pokedexNum;
    }

    public int getPokemonHPBaseStat() {
        return hp;
    }

    public int getPokemonAttackBaseStat() {
        return atk;
    }

    public int getPokemonDefenseBaseStat() {
        return def;
    }

    public int getPokemonSpecialAttackBaseStat() {
        return spAtk;
    }

    public int getPokemonSpecialDefenseBaseStat() {
        return spDef;
    }

    public int getPokemonSpeedBaseStat() {
        return speed;
    }
}
