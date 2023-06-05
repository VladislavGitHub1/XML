package com.chernenkov.xml.entity;

import java.util.List;

public class Card {
    private String id;
    private String barcode;
    private String thema;
    private String type;
    private String country;
    private int year;
    private Author author = new Author();
    private boolean valuable;

    public Card() {
    }


    public Card(String id, String barcode, String thema, String type, String country, int year, Author author, boolean valuable) {
        this.id = id;
        this.thema = thema;
        this.type = type;
        this.country = country;
        this.year = year;
        this.author = author;
        this.valuable = valuable;
        this.barcode = barcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isValuable() {
        return valuable;
    }

    public void setValuable(boolean valuable) {
        this.valuable = valuable;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("id=").append(id);
        sb.append(", barcode=").append(barcode);
        sb.append(", thema='").append(thema).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", year=").append(year);
        sb.append(", author=").append(author);
        sb.append(", valuable=").append(valuable);
        sb.append('}');
        return sb.toString();
    }

    public class Author {
        private String firstName;
        private String lastName;

        public Author() {
        }

        public Author(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Author{");
            sb.append("firstName='").append(firstName).append('\'');
            sb.append(", lastName='").append(lastName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
