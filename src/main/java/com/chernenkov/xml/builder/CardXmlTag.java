package com.chernenkov.xml.builder;

public enum CardXmlTag {
    CARDS("cards"),
    ID("id"),
    BARCODE("barcode"),
    THEMA("thema"),
    TYPE("type"),
    COUNTRY("country"),
    YEAR("year"),
    AUTHOR("author"),
    FIRSTNAME("firstName"),
    LASTNAME("lastName"),
    VALUABLE("valuable");


    private String value;
    CardXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
