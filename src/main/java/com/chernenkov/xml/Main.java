package com.chernenkov.xml;

import com.chernenkov.xml.builder.impl.CardsDomBuilder;
import com.chernenkov.xml.builder.impl.CardsSaxBuilder;
import com.chernenkov.xml.validator.XmlValidator;

public class Main {
    public static void main(String[] args) {
        XmlValidator xmlValidator = new XmlValidator();
        xmlValidator.validate();
//        CardsSaxBuilder saxBuilder = new CardsSaxBuilder();
//        saxBuilder.buildSetCards("data/cards.xml");
//        System.out.println(saxBuilder.getCards());
        CardsDomBuilder domBuilder = new CardsDomBuilder();
        domBuilder.buildSetCards("data/cards.xml");
        System.out.println(domBuilder.getCards());
    }
}