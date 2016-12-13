package com.pokedeck.cards;

public class Card {
    //Atributes
    private String cardName;
    private String type;
    private int cardNumber;

    //Constructor
    public Card(String cardName, String type) {
        this.cardName = cardName;
        this.type = type;
    }

    //Getter & Setter
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardName='" + cardName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
