package com.chernenkov.xml.builder.impl;

import com.chernenkov.xml.entity.Card;
import com.chernenkov.xml.handler.CardHandler;
import com.chernenkov.xml.validator.CardErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CardsSaxBuilder {
    private Set<Card> cards;
    private CardHandler handler = new CardHandler();
    private XMLReader reader;

    public CardsSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            reader.setErrorHandler(new CardErrorHandler());
            reader.setContentHandler(handler);
        }
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void buildSetCards(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
        cards = handler.getCards();
    }
}
