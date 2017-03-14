package com.pokedeck.cards;

public class TrainerCard extends Card{

    private TrainerType trainerType;

    public TrainerCard(String cardName, int cardID, TrainerType trainerType) {
        super(cardName, CardType.Trainer , cardID);
        this.trainerType = trainerType;
    }

    public TrainerType getTrainerType() {
        return trainerType;
    }
}
