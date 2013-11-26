package org.cameron.ivcalculator;

/**
 * This is a simple class to represent a Pokemon. The class supports querying a
 * XML file following a certain format to be represented. Also, allows a programmatical
 * representation of a Pokemon.
 * @author Cameron Roe
 * @version dev
 */
public class Pokemon {
    // Instance fields
    private String pokemonName; // Name of the Pokemon.
    private Nature pokemonNature; // The Pokemon Nature as a Java object. Provided by the user.
    private int baseHP, baseAtk, baseDef, baseSpA, baseSpD, baseSpeed; // Pokemon base stats
    private int level; // Pokemon level up to 100
    private int[] stats = new int[6]; // The actual stats of the Pokemon. These are provided by the user.
    private int[] evs = new int[6]; // Pokemon EVs. Provided by the user.
    private int[] baseStats = new int[6]; // Base stats of the Pokemon. Provided by the programmer, or XML files.
    private int[] ivs = new int[6]; // The IVs of the Pokemon. These are calculated by the class.
    private HiddenPower pokemonHp;

    /**
     * Parses through an XML file to get all the relevant Pokemon information.
     * The library comes with a directory with all of the Pokemon, so you should
     * just use this one with those files.
     * The EVs are an argument though, because not every Pokemon will have the
     * same EVs. Same with Nature. This constructor has Nature as a Nature object.
     * @param xmlFile The XML file to parse through. Most likely will be ./pokemon/Name.xml
     */
    public Pokemon(String xmlFile, int level, Nature nat, int HPEv, int atkEv, int defEv, int spAEv,
                    int spDEv, int speedEv, int[] stats) {
        PokemonXMLParser parseFile = new PokemonXMLParser(xmlFile);
        PokemonXMLData data = parseFile.parseFile();
        this.pokemonName = data.getPokemonName();
        setPokemonBaseStats(data.getPokemonHPBaseStat(),
                            data.getPokemonAttackBaseStat(),
                            data.getPokemonDefenseBaseStat(),
                            data.getPokemonSpecialAttackBaseStat(),
                            data.getPokemonSpecialDefenseBaseStat(),
                            data.getPokemonSpeedBaseStat());
        this.level = level;
        this.pokemonNature = nat;
        setPokemonEVs(HPEv, atkEv, defEv, spAEv, spDEv, speedEv);
        setPokemonStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    /**
     * Parses through an XML file to get all the relevant Pokemon information.
     * The library comes with a directory with all of the Pokemon, so you should
     * just use this one with those files.
     * The EVs are an argument though, because not every Pokemon will have the
     * same EVs. Same with Nature. This constructor has Nature as a String object.
     * @param xmlFile The XML file to parse through. Most likely will be ./pokemon/Name.xml
     */
    public Pokemon(String xmlFile, int level, String nat, int HPEv, int atkEv, int defEv, int spAEv,
                    int spDEv, int speedEv, int[] stats) {
        PokemonXMLParser parseFile = new PokemonXMLParser(xmlFile);
        PokemonXMLData data = parseFile.parseFile();
        setPokemonBaseStats(data.getPokemonHPBaseStat(),
                            data.getPokemonAttackBaseStat(),
                            data.getPokemonDefenseBaseStat(),
                            data.getPokemonSpecialAttackBaseStat(),
                            data.getPokemonSpecialDefenseBaseStat(),
                            data.getPokemonSpeedBaseStat());
        this.level = level;
        this.pokemonNature = Nature.parseNatureString(nat);
        setPokemonEVs(HPEv, atkEv, defEv, spAEv, spDEv, speedEv);
        setPokemonStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    /**
     * Constructor that uses arrays for stats. Takes the Nature as a Nature object. Rest is self-explanatory.
     * @param name The name of the Pokemon
     * @param nat The nature of the Pokemon as a Nature object.
     * @param baseStats The base stats of the Pokemon. Should be ordered { HP, atk, def, spAtk, spDef, speed }
     * @param evs The EVs of the Pokemon. Should be ordered the same as above.
     * @param level The level of the Pokemon. Must be between 1-100 or it's an invalid Pokemon.
     */
    public Pokemon(String name, Nature nat, int[] baseStats, int[] evs, int level, int[] stats) {
        pokemonName = name;
        pokemonNature = nat;
        setPokemonBaseStats(baseStats[0], baseStats[1], baseStats[2], baseStats[3], baseStats[4], baseStats[5]);
        this.level = level;
        setPokemonEVs(evs[0], evs[1], evs[2], evs[3], evs[4], evs[5]);
        setPokemonStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    /**
     * Constructor that takes all the states individually. Takes the Nature as a Nature object. Rest is self-explanatory.
     * @param name The name of the Pokemon
     * @param nat The nature of the Pokemon as a Nature object.
     * @param hp HP base stat
     * @param atk Attack base stat
     * @param def Defense base stat
     * @param spAtk Special Attack base stat
     * @param spDef Special Defense base stat
     * @param speed Speed base stat
     * @param hpEv HP EVs
     * @param atkEv Attack EVs
     * @param defEv Defense EVs
     * @param spAEv Special Attack EVs
     * @param spDEv Special Defense EVs
     * @param speedEv Speed EVs
     * @param level The level of the Pokemon between 1 and 100.
     */
    public Pokemon(String name, Nature nat, int hp, int atk, int def, int spAtk, int spDef, int speed,
                    int hpEv, int atkEv, int defEv, int spAEv, int spDEv, int speedEv, int level, int[] stats) {
        pokemonName = name;
        pokemonNature = nat;
        setPokemonBaseStats(hp, atk, def, spAtk, spDef, speed);
        this.level = level;
        setPokemonEVs(hpEv, atkEv, defEv, spAEv, spDEv, speedEv);
        setPokemonStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    /**
     * Constructor that takes stats as arrays. Takes the Nature as a String object. Rest is self-explanatory.
     * @param name The name of the Pokemon
     * @param nature The nature of the Pokemon as a String
     * @param baseStats The stats of the Pokemon. Should be ordered { HP, atk, def, spAtk, spDef, speed }
     * @param evs The EVs of the Pokemon. Should be ordered as above.
     * @param level The level of the Pokemon between 1 and 100.
     */
    public Pokemon(String name, String nature, int[] baseStats, int[] evs, int level, int[] stats) {
        pokemonName = name;
        pokemonNature = Nature.parseNatureString(nature);
        setPokemonBaseStats(baseStats[0], baseStats[1], baseStats[2], baseStats[3], baseStats[4], baseStats[5]);
        this.level = level;
        setPokemonEVs(evs[0], evs[1], evs[2], evs[3], evs[4], evs[5]);
        setPokemonStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    /**
     * Constructor that takes all the states individually. Takes the Nature as a String object. Rest is self-explanatory.
     * @param name The name of the Pokemon
     * @param nat The nature of the Pokemon as a Nature object.
     * @param hp HP base stat
     * @param atk Attack base stat
     * @param def Defense base stat
     * @param spAtk Special Attack base stat
     * @param spDef Special Defense base stat
     * @param speed Speed base stat
     * @param hpEv HP EVs
     * @param atkEv Attack EVs
     * @param defEv Defense EVs
     * @param spAEv Special Attack EVs
     * @param spDEv Special Defense EVs
     * @param speedEv Speed EVs
     * @param level The level of the Pokemon between 1 and 100.
     */
    public Pokemon(String name, String nat, int hp, int atk, int def, int spAtk, int spDef, int speed,
                    int hpEv, int atkEv, int defEv, int spAEv, int spDEv, int speedEv, int level, int[] stats) {
        pokemonName = name;
        pokemonNature = Nature.parseNatureString(nat);
        setPokemonBaseStats(hp, atk, def, spAtk, spDef, speed);
        this.level = level;
        setPokemonEVs(hpEv, atkEv, defEv, spAEv, spDEv, speedEv);
        setPokemonStats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
    }

    private void setPokemonStats(int hp, int atk, int def, int spA, int spD, int speed) {
        stats[0] = hp;
        stats[1] = atk;
        stats[2] = def;
        stats[3] = spA;
        stats[4] = spD;
        stats[5] = speed;
    }

    private void setPokemonEVs(int hp, int atk, int def, int spA, int spD, int speed) {
        evs[0] = hp;
        evs[1] = atk;
        evs[2] = def;
        evs[3] = spA;
        evs[4] = spD;
        evs[5] = speed;
    }

    private void setPokemonBaseStats(int hp, int atk, int def, int spA, int spD, int speed) {
        baseStats[0] = hp;
        baseStats[1] = atk;
        baseStats[2] = def;
        baseStats[3] = spA;
        baseStats[4] = spD;
        baseStats[5] = speed;
    }

    /**
     * This method calculates the IVs of the Pokemon and puts the values in the IVs array.
     * ivs[0] = HP
     * ivs[1] = Atk
     * ivs[2] = Def
     * ivs[3] = SpAtk
     * ivs[4] = SpDef
     * ivs[5] = Speed
     */
    public void calculateIVs() {
        ivs[0] = calculateHpIv(baseStats[0], level, evs[0], stats[0]);
        ivs[1] = calculateAtkIv(baseStats[1], level, evs[1], stats[1]);
        ivs[2] = calculateDefIv(baseStats[2], level, evs[2], stats[2]);
        ivs[3] = calculateSpAtkIv(baseStats[3], level, evs[3], stats[3]);
        ivs[4] = calculateSpDefIv(baseStats[4], level, evs[4], stats[4]);
        ivs[5] = calculateSpeedIv(baseStats[5], level, evs[5], stats[5]);
        pokemonHp = new HiddenPower(ivs);
    }

    /**
     * Performs HP IV calculation and returns the value as an integer.
     * @param baseStat The base value for the HP stat of the Pokemon.
     * @param level The Pokemon's level. Value is between 1 and 100.
     * @param ev The amount of EVs you have for the HP stat.
     * @param statVal The actual value of the HP stat of the Pokemon.
     * @return The HP IV approximation as an integer.
     */
    private int calculateHpIv(int baseStat, int level, int ev, int statVal) {
        return (int) (((statVal - level - 10) * 100 / level) - 2 * baseStat - Math.floor(ev / 4));
    }

    /**
     * Performs the Attack IV calculation and returns the value as an integer.
     * @param baseStat The base value for the Attack stat of the Pokemon.
     * @param level The Pokemon's level. Value is between 1 and 100.
     * @param ev The amount of EVs you have for the Attack stat.
     * @param statVal The actual value of the Attack stat of the Pokemon.
     * @return The Attack IV approximation as an integer.
     */
    private int calculateAtkIv(int baseStat, int level, int ev, int statVal) {
        double mult = pokemonNature.getAttackMultiplier();
        return (int) (((Math.ceil(statVal / mult) - 5) * 100 / level) - 2 * baseStat - Math.floor(ev / 4));
    }

    /**
     * Performs the Defense IV calculation and returns the value as an integer.
     * @param baseStat The base value for the Defense stat of the Pokemon.
     * @param level The Pokemon's level. Value is between 1 and 100.
     * @param ev The amount of EVs you have for the Defense stat.
     * @param statVal The actual value of the Defense stat of the Pokemon.
     * @return The Defense IV approximation as an integer.
     */
    private int calculateDefIv(int baseStat, int level, int ev, int statVal) {
        double mult = pokemonNature.getDefenseMultiplier();
        return (int) (((Math.ceil(statVal / mult) - 5) * 100 / level) - 2 * baseStat - Math.floor(ev / 4));
    }

    /**
     * Performs the Special Attack IV calculation and returns the value as an integer.
     * @param baseStat The base value for the Special Attack stat of the Pokemon.
     * @param level The Pokemon's level. Value is between 1 and 100.
     * @param ev The amount of EVs you have for the Special Attack stat.
     * @param statVal The actual value of the Special Attack stat of the Pokemon.
     * @return The Special Attack IV approximation as an integer.
     */
    private int calculateSpAtkIv(int baseStat, int level, int ev, int statVal) {
        double mult = pokemonNature.getSpecialAttackMultiplier();
        return (int) (((Math.ceil(statVal / mult) - 5) * 100 / level) - 2 * baseStat - Math.floor(ev / 4));
    }
    
    private int calculateSpDefIv(int baseStat, int level, int ev, int statVal) {
        double mult = pokemonNature.getSpecialDefenseMultiplier();
        return (int) (((Math.ceil(statVal / mult) - 5) * 100 / level) - 2 * baseStat - Math.floor(ev / 4));
    }
    
    private int calculateSpeedIv(int baseStat, int level, int ev, int statVal) {
        double mult = pokemonNature.getSpeedMultiplier();
        return (int) (((Math.ceil(statVal / mult) - 5) * 100 / level) - 2 * baseStat - Math.floor(ev / 4));
    }
   
    public int[] getPokemonStats() {
        int[] statsToReturn = new int[6];
        System.arraycopy(stats, 0, statsToReturn, 0, statsToReturn.length);
        return statsToReturn;
    }

    public int[] getPokemonEVs() {
        int[] evsToReturn = new int[6];
        System.arraycopy(evs, 0, evsToReturn, 0, evsToReturn.length);
        return evsToReturn;
    }

    public int[] getPokemonIVs() {
        int[] ivsToReturn = new int[6];
        System.arraycopy(ivs, 0, ivsToReturn, 0, ivsToReturn.length);
        return ivsToReturn;
    }
    
    public HiddenPower getPokemonHiddenPower() {
        return pokemonHp;
    }

    public static void main(String[] args) {
        int[] stats = {224, 141, 134, 132, 136, 98};
        Pokemon bulbasaur = new Pokemon("./pokemon/Bulbasaur.xml", 100, Nature.ADAMANT,
                0, 0, 0, 0, 0, 0, stats);
        bulbasaur.calculateIVs();
        int[] ivs = bulbasaur.getPokemonIVs();
        /*
         * IVs of the Bulbasaur:
         * HP = 24
         * Attack = 26
         * Defense = 31
         * Special Attack = 12
         * Special Defense = 1
         * Speed = 3
         */
        System.out.println("IVs of the Bulbasaur");
        System.out.println("HP: " + ivs[0] + "\tExpected: 24");
        System.out.println("Attack: " + ivs[1] + "\tExpected: 26");
        System.out.println("Defense: " + ivs[2] + "\tExpected: 31");
        System.out.println("Special Attack: " + ivs[3] + "\tExpected: 12");
        System.out.println("Special Defense: " + ivs[4] + "\tExpected: 1");
        System.out.println("Speed: " + ivs[5] + "\tExpected: 3");
        HiddenPower hiddenPower = bulbasaur.getPokemonHiddenPower();
        System.out.println("Hidden Power - Type: " + hiddenPower.getType().getTypeByString() + "\tExpected: Grass");
        System.out.println("Hidden Power - Power: " + hiddenPower.getPower() + "\tExpected: =~ 38");
        
    }
}
