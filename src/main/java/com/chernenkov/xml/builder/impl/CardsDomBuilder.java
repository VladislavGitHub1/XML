package com.chernenkov.xml.builder.impl;

import com.chernenkov.xml.builder.CardsBuilder;
import com.chernenkov.xml.entity.Card;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CardsDomBuilder implements CardsBuilder {
    private Set<Card> cards;
    private DocumentBuilder docBuilder;

    public CardsDomBuilder() {
        cards = new HashSet<Card>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void buildSetCards(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList cardsList = root.getElementsByTagName("card");
            for (int i = 0; i < cardsList.getLength(); i++) {
                Element cardElement = (Element) cardsList.item(i);
                Card card = buildCard(cardElement);
                cards.add(card);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Card buildCard(Element cardElement) {
        Card card = new Card();
        card.setId(Integer.parseInt(cardElement.getAttribute("id")));
        card.setYear(Integer.parseInt(getElementTextContent(cardElement, "year")));
        card.setThema(getElementTextContent(cardElement, "thema"));
        card.setValuable(Boolean.parseBoolean(getElementTextContent(cardElement, "valuable")));
        card.setType(getElementTextContent(cardElement, "type"));
        Card.Author author = card.getAuthor();
        Element authorElement =
                (Element) cardElement.getElementsByTagName("author").item(0);
        author.setFirstName(getElementTextContent(authorElement, "firstName"));
        author.setLastName(getElementTextContent(authorElement, "lastName"));
        return card;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

