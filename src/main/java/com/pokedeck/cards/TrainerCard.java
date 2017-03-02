package com.pokedeck.cards;

public class TrainerCard extends Card{

    private TrainerType trainerType;

    public TrainerCard(String cardName, TrainerType trainerType) {
        super(cardName, CardType.Trainer);
        this.trainerType = trainerType;
    }

    public TrainerType getTrainerType() {
        return trainerType;
    }
}
