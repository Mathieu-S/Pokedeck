package com.pokedeck.cards;

import java.io.Serializable;

/**
 * Class Card
 */
public class Card implements Serializable {

    private String cardName;
    private CardType type;
    private int cardID;

    /**
     * Create new card.
     * @param cardName Define the name of the card
     * @param cardType Difine the type of the card. Use Enum form CardType.
     * @param cardID Define the ID of the card
     */
    public Card(String cardName, CardType cardType, int cardID) {
        this.cardName = cardName;
        this.type = cardType;
        this.cardID = cardID;
    }

    /**
     * Get name of card
     * @return String name of card
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Set name of card
     * @param cardName String name of card
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Get type of card
     * @return CardType Enum
     */
    public CardType getType() {
        return type;
    }

    /**
     * Set type of card
     * @param type CardType Enum
     */
    public void setType(CardType type) {
        this.type = type;
    }

    /**
     * Get ID of card
     * @return int
     */
    public int getCardID() {
        return cardID;
    }

    /**
     * Set ID of card
     * @param cardID int
     */
    public void setCardID(int cardID) {
        this.cardID = cardID;
    }
}
