/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cameron.ivcalculator;

/**
 * Represents a Pokemon nature. The class is full of pre-defined constants
 * so you don't have to define them. You're welcome. The class is fairly complex
 * otherwise. A simple definition is that the stat multipliers are listed in an
 * array with a simple format:<br /><code>
 * array[0] = Atk<br />
 * array[1] = Def<br />
 * array[2] = Sp. Atk<br />
 * array[3] = Sp. Def<br />
 * array[4] = Speed<br /></code>
 * The array has the multipliers as doubles, so you can just apply it to the stat
 * @author Cameron Roe
 * @version dev
 */
public class Nature {
    private double[] multipliers = new double[5];

    // List of natures as constants. Only because I'm a nice guy. :)
    // I'll sort them by stat raised and leave a comment describing what stat it decreases
    // Atk+
    public static final Nature HARDY = new Nature(1,1,1,1,1); //Atk+, Atk-
    public static final Nature LONELY = new Nature(1.1,0.9,1,1,1); //Atk+, Def-
    public static final Nature BRAVE = new Nature(1.1,1,1,1,0.9); //Atk+, Speed-
    public static final Nature NAUGHTY = new Nature(1.1,1,1,0.9,1); //Atk+, Sp. Def-
    public static final Nature ADAMANT = new Nature(1.1,1,0.9,1,1); //Atk+, Sp. Atk-

    // Def+
    public static final Nature DOCILE = new Nature(1,1,1,1,1); //Def+, Def-
    public static final Nature BOLD = new Nature(0.9,1.1,1,1,1); //Def+, Atk-
    public static final Nature RELAXED = new Nature(1,1.1,1,1,0.9); //Def+, Speed-
    public static final Nature IMPISH = new Nature(1,1.1,0.9,1,1); //Def+, Sp. Atk-
    public static final Nature LAX = new Nature(1,1.1,1,0.9,1); //Def+, Sp. Def-

    // Speed+
    public static final Nature SERIOUS = new Nature(1,1,1,1,1); //Speed+, Speed-
    public static final Nature TIMID = new Nature(0.9,1,1,1,1.1); //Speed+, Atk-
    public static final Nature HASTY = new Nature(1,0.9,1,1,1.1); //Speed+, Def-
    public static final Nature JOLLY = new Nature(1,1,0.9,1,1.1); //Speed+, Sp. Atk-
    public static final Nature NAIVE = new Nature(1,1,1,0.9,1.1); //Speed+, Sp. Def-

    // Sp. Atk+
    public static final Nature BASHFUL = new Nature(1,1,1,1,1); //Sp. Atk+, Sp. Atk-
    public static final Nature MODEST = new Nature(0.9,1,1.1,1,1); //Sp. Atk+, Atk-
    public static final Nature MILD = new Nature(1,0.9,1.1,1,1); //Sp. Atk+, Def-
    public static final Nature QUIET = new Nature(1,1,1.1,1,0.9); //Sp. Atk+, Speed-
    public static final Nature RASH = new Nature(1,1,1.1,0.9,1); //Sp. Atk+, Sp. Def-

    // Sp. Def+
    public static final Nature QUIRKY = new Nature(1,1,1,1,1); //Sp. Def+, Sp. Def-
    public static final Nature CALM = new Nature(0.9,1,1,1.1,1); //Sp. Def+, Atk-
    public static final Nature GENTLE = new Nature(1,0.9,1,1.1,1); //Sp. Def+, Def-
    public static final Nature SASSY = new Nature(1,1,1,1.1,0.9); //Sp. Def+, Speed-
    public static final Nature CAREFUL = new Nature(1,1,0.9,1.1,0); //Sp. Def+, Sp. Atk-

    /**
     * Method to define a Nature. Please don't use this yourself unless you are
     * sure you know what you are doing. There are constants for all the natures
     * that will be better to use.
     * @param atk Atk multiplier
     * @param def Def multiplier
     * @param spAtk Sp. Atk muliplier
     * @param spDef Sp. Def multiplier
     * @param speed Speed multiplier
     */
    public Nature(double atk, double def, double spAtk, double spDef, double speed) {
        multipliers[0] = atk;
        multipliers[1] = def;
        multipliers[2] = spAtk;
        multipliers[3] = spDef;
        multipliers[4] = speed;
    }

    /**
     * This is my incredibly ghetto method to parse a String and return it as a
     * Nature object. It's just a flow of conditionals.
     * @param nat The nature as a string. Not case-sensitive
     * @return The Nature given as a Nature object
     */
    public static Nature parseNatureString(String nat) {
        String chk = nat.toLowerCase();
        // Atk+ Natures
        if(chk.equals("hardy"))
            return Nature.HARDY;
        else if(chk.equals("lonely"))
            return Nature.LONELY;
        else if(chk.equals("brave"))
            return Nature.BRAVE;
        else if(chk.equals("naughty"))
            return Nature.NAUGHTY;
        else if(chk.equals("adamant"))
            return Nature.ADAMANT;

        // Def+ Natures
        else if(chk.equals("docile"))
            return Nature.DOCILE;
        else if(chk.equals("bold"))
            return Nature.BOLD;
        else if(chk.equals("relaxed"))
            return Nature.RELAXED;
        else if(chk.equals("impish"))
            return Nature.IMPISH;
        else if(chk.equals("lax"))
            return Nature.LAX;

        // Speed+ Natures
        else if(chk.equals("serious"))
            return Nature.SERIOUS;
        else if(chk.equals("timid"))
            return Nature.TIMID;
        else if(chk.equals("hasty"))
            return Nature.HASTY;
        else if(chk.equals("jolly"))
            return Nature.JOLLY;
        else if(chk.equals("naive"))
            return Nature.NAIVE;

        // Sp. Atk+ Natures
        else if(chk.equals("bashful"))
            return Nature.BASHFUL;
        else if(chk.equals("modest"))
            return Nature.MODEST;
        else if(chk.equals("mild"))
            return Nature.MILD;
        else if(chk.equals("quiet"))
            return Nature.QUIET;
        else if(chk.equals("rash"))
            return Nature.RASH;

        //Sp. Def+ Natures
        else if(chk.equals("quirky"))
            return Nature.QUIRKY;
        else if(chk.equals("calm"))
            return Nature.CALM;
        else if(chk.equals("gentle"))
            return Nature.GENTLE;
        else if(chk.equals("sassy"))
            return Nature.SASSY;
        else if(chk.equals("careful"))
            return Nature.CAREFUL;

        //This shouldn't happen, but Java will hate me if I don't have a default
        else
            return null;
    }

    // Methods to return multipliers of specific stats.
    /**
     * Method to access the attack multiplier of the Nature
     * @return The attack multiplier. Will be 1, 0.9, or 1.1
     */
    public double getAttackMultiplier() {
        return multipliers[0];
    }

    /**
     * Method to access the defense multiplier of the Nature
     * @return The defense multiplier. Will be 1, 0.9, or 1.1
     */
    public double getDefenseMultiplier() {
        return multipliers[1];
    }

    /**
     * Method to access the special attack multiplier of the Nature
     * @return The special attack multiplier. Will be 1, 0.9, or 1.1
     */
    public double getSpecialAttackMultiplier() {
        return multipliers[2];
    }

    /**
     * Method to access the special defense multiplier of the Nature
     * @return The special defense multiplier. Will be 1, 0.9, or 1.1
     */
    public double getSpecialDefenseMultiplier() {
        return multipliers[3];
    }

    public double getSpeedMultiplier() {
        return multipliers[4];
    }
}
