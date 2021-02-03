package edu.blackjack.model;

import java.util.Objects;

public class Card {
    private Suit suit;
    private Nominal nominal;
    private int value;
    private String img;


    public Card() {

    }

    public Card(Suit suit, Nominal nominal, int value) {
        this.suit = suit;
        this.nominal = nominal;
        this.value = value;
    }

    public Card(Suit suit, Nominal nominal, int value, String img) {
        this.suit = suit;
        this.nominal = nominal;
        this.value = value;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public void setNominal(Nominal nominal) {
        this.nominal = nominal;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", nominal=" + nominal +
                ", value=" + value +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getSuit() == card.getSuit() &&
                getNominal() == card.getNominal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getNominal());
    }
}
