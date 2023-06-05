package com.chernenkov.xml.builder.impl;

import com.chernenkov.xml.entity.Card;
import com.chernenkov.xml.handler.CardHandler;
import com.chernenkov.xml.validator.CardErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CardsSaxBuilder {
    static Logger logger = LogManager.getLogger();
    private Set<Card> cards;
    private CardHandler handler = new CardHandler();
    private XMLReader reader;

    public CardsSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.warn(e);
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
           logger.warn(e);
        }
        cards = handler.getCards();
    }
}
