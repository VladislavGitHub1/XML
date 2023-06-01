package com.chernenkov.xml.builder;

import com.chernenkov.xml.entity.Card;

import java.util.Set;

public interface CardsBuilder {
    void buildSetCards(String filename);
    public Set<Card> getCards();
}
