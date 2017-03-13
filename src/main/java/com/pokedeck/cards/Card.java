package com.pokedeck.cards;

import java.io.Serializable;

public class Card implements Serializable {
    //Atributes
    private String cardName;
    private CardType type;
    private int cardID;

    //Constructor
    public Card(String cardName, CardType cardType, int cardID) {
        this.cardName = cardName;
        this.type = cardType;
        this.cardID = cardID;
    }

    //Getter & Setter
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardName='" + cardName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
