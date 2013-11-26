/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cameron.ivcalculator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * Handler class inherited from DefaultHandler. Defines what happens with events
 * during parsing with SAX.
 * @author Cameron Roe
 * @version dev
 */
public class PokemonXMLParserHandler extends DefaultHandler {
    // Bunch of boolean variables to check for occurrence of these elements.
    private boolean nameElement = false,
            pokedexNumElement = false,
            hpElement = false,
            atkElement = false,
            defElement = false,
            spAtkElement = false,
            spDefElement = false,
            speedElement = false;

    private String name;
    private String pokedexNum, hp, atk, def, spAtk, spDef, speed;
    

    // Blank constructor
    public PokemonXMLParserHandler() {
        // Do nothing
    }

    // Override methods of the DefaultHandler class
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Debug code. Print out the name of the element.
        System.out.println("Starting element " + qName);
        // Screw Java's text processing abilities
        // Switch statements should work with Strings. Those bastards.
        if(qName.equalsIgnoreCase("name"))
            nameElement = true;
        else if(qName.equalsIgnoreCase("pokedexnum"))
            pokedexNumElement = true;
        else if(qName.equalsIgnoreCase("hp"))
            hpElement = true;
        else if(qName.equalsIgnoreCase("atk"))
            atkElement = true;
        else if(qName.equalsIgnoreCase("def"))
            defElement = true;
        else if(qName.equalsIgnoreCase("spatk"))
            spAtkElement = true;
        else if(qName.equalsIgnoreCase("spdef"))
            spDefElement = true;
        else if(qName.equalsIgnoreCase("speed"))
            speedElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Debug code
        if(qName.equalsIgnoreCase("name"))
            nameElement = false;
        else if(qName.equalsIgnoreCase("pokedexnum"))
            pokedexNumElement = false;
        else if(qName.equalsIgnoreCase("hp"))
            hpElement = false;
        else if(qName.equalsIgnoreCase("atk"))
            atkElement = false;
        else if(qName.equalsIgnoreCase("def"))
            defElement = false;
        else if(qName.equalsIgnoreCase("spatk"))
            spAtkElement = false;
        else if(qName.equalsIgnoreCase("spdef"))
            spDefElement = false;
        else if(qName.equalsIgnoreCase("speed"))
            speedElement = false;
        System.out.println("Ending element " + qName);

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // This is the juicy part. The boolean variables tell us when we've
        // encountered a specific element. With this, we check which element
        // we're at and act accordingly.
        if(nameElement) {
            name = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(pokedexNumElement) {
            pokedexNum = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(hpElement) {
            hp = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(atkElement) {
            atk = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(defElement) {
            def = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(spAtkElement) {
            spAtk = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(spDefElement) {
            spDef = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        } if(speedElement) {
            speed = new String(ch, start, length);
            System.out.println("debug: " + new String(ch, start, length));
        }

    }

    public PokemonXMLData deriveXMLData() {
        return new PokemonXMLData(name, pokedexNum, hp, atk, def, spAtk, spDef, speed);
    }
}
