package com.chernenkov.xml.handler;

import com.chernenkov.xml.builder.CardXmlTag;
import com.chernenkov.xml.entity.Card;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CardHandler extends DefaultHandler {
    private Set<Card> cards;
    private Card current;
    private CardXmlTag currentXmlTag;
    private EnumSet<CardXmlTag> withText;
    private static final String ELEMENT_CARD = "card";
    public CardHandler() {
        cards = new HashSet<Card>();
        withText = EnumSet.range(CardXmlTag.THEMA, CardXmlTag.VALUABLE);
    }
    public Set<Card> getCards() {
        return cards;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CARD.equals(qName)) {
            current = new Card();
            current.setId(Integer.parseInt(attrs.getValue(0)));
        } else {
            CardXmlTag temp = CardXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CARD.equals(qName)) {
            cards.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case THEMA -> current.setThema(data);
                case TYPE -> current.setType(data);
                case COUNTRY -> current.setCountry(data);
                case FIRSTNAME -> current.getAuthor().setFirstName(data);
                case LASTNAME -> current.getAuthor().setLastName(data);
                case YEAR -> current.setYear(Integer.parseInt(data));
                case VALUABLE -> current.setValuable(Boolean.parseBoolean(data));
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}

