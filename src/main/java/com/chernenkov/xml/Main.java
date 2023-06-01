package com.chernenkov.xml;

import com.chernenkov.xml.builder.CardsDomBuilder;
import com.chernenkov.xml.builder.CardsSaxBuilder;
import com.chernenkov.xml.entity.Card;
import com.chernenkov.xml.parser.ConsoleCardHandler;
import com.chernenkov.xml.validator.CardErrorHandler;
import com.chernenkov.xml.validator.XmlValidator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.imageio.IIOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XmlValidator xmlValidator = new XmlValidator();
        xmlValidator.validate();
        CardsSaxBuilder saxBuilder = new CardsSaxBuilder();
        saxBuilder.buildSetCards("data/cards.xml");
        System.out.println(saxBuilder.getCards());
//        CardsDomBuilder domBuilder = new CardsDomBuilder();
//        domBuilder.buildSetCards("data/cards.xml");
//        System.out.println(domBuilder.getCards());
    }
}