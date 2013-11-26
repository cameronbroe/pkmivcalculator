package org.cameron.ivcalculator;

import java.io.FileReader;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
/**
 * This class opens an XML file following a specific format for a Pokemon and
 * parses the file to get Pokemon stats.
 * Here is an example of the XML format.<br />
 * <code>&lt;pokemon&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;name&gt;Bulbasaur&lt;/name&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;pokedexnum&gt;1&lt;/pokedexnum&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;basestats&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;hp&gt;45&lt;/hp&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;atk&gt;49&lt;/atk&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;def&gt;49&lt;/def&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;spatk&gt;65&lt;/spatk&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;spdef&gt;65&lt;/spdef&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;speed&gt;45&lt;/speed&gt;<br />
 * &nbsp;&nbsp;&nbsp;&nbsp;&lt;/basestats&gt;<br />
 * &lt;/pokemon&gt;</code>
 * @author Cameron Roe
 * @version dev
 */
public class PokemonXMLParser {
    private PokemonXMLParserHandler handler = new PokemonXMLParserHandler();
    private PokemonXMLData data;
    private String xmlFile;

    public PokemonXMLParser(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public String getXMLFileName() {
        return xmlFile;
    }

    public void deriveData() {
        data = handler.deriveXMLData();
    }

    public PokemonXMLData getData() {
        return data;
    }

    public PokemonXMLParserHandler getHandler() {
        return handler;
    }

    public PokemonXMLData parseFile() {
        try {
            XMLReader read = XMLReaderFactory.createXMLReader();
            PokemonXMLParser pokemon = new PokemonXMLParser(xmlFile);
            FileReader r = new FileReader(pokemon.getXMLFileName());
            InputSource source = new InputSource(r);
            read.setContentHandler(pokemon.getHandler());
            read.parse(source);
            pokemon.deriveData();
            PokemonXMLData pokemonData = pokemon.getData();
            return pokemonData;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public static void main(String[] args) {
        try {
            XMLReader read = XMLReaderFactory.createXMLReader();
            PokemonXMLParser bulbasaur = new PokemonXMLParser("./pokemon/Bulbasaur.xml");
            FileReader r = new FileReader(bulbasaur.getXMLFileName());
            InputSource source = new InputSource(r);
            read.setContentHandler(bulbasaur.getHandler());
            read.parse(source);
            bulbasaur.deriveData();
            PokemonXMLData bulbasaurData = bulbasaur.getData();
            System.out.println("\nPokemon Stats:");
            System.out.println("Name: " + bulbasaurData.getPokemonName());
            System.out.println("Pokedex Number: " + bulbasaurData.getPokedexNumber());
            System.out.println("HP Base Stat: " + bulbasaurData.getPokemonHPBaseStat());
            System.out.println("Attack Base Stat: " + bulbasaurData.getPokemonAttackBaseStat());
            System.out.println("Defense Base Stat: " + bulbasaurData.getPokemonDefenseBaseStat());
            System.out.println("Special Attack Base Stat: " + bulbasaurData.getPokemonSpecialAttackBaseStat());
            System.out.println("Special Defense Base Stat: " + bulbasaurData.getPokemonSpecialDefenseBaseStat());
            System.out.println("Speed Base Stat: " + bulbasaurData.getPokemonSpeedBaseStat());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
