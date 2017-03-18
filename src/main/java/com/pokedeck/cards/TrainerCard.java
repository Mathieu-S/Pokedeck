package com.pokedeck.cards;

/**
 * Class TrainerCard, extend the Class Card
 */
public class TrainerCard extends Card{

    private TrainerType trainerType;

    /**
     * Create a TrainerCard
     * @param cardName Define the name of the card
     * @param cardID Define the ID of the card
     * @param trainerType Define the type of energy. Use Enum form TrainerType
     */
    public TrainerCard(String cardName, int cardID, TrainerType trainerType) {
        super(cardName, CardType.Trainer , cardID);
        this.trainerType = trainerType;
    }

    /**
     * Get the trainer type of the card
     * @return TrainerType of card
     */
    public TrainerType getTrainerType() {
        return trainerType;
    }

    /**
     * Set the trainer type of the card
     * @param trainerType TrainerType Enum
     */
    public void setTrainerType(TrainerType trainerType) {
        this.trainerType = trainerType;
    }
}
