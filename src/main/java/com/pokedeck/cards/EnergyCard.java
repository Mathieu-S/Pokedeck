package com.pokedeck.cards;

public class EnergyCard extends Card{

    private EnergyType energyType;

    public EnergyCard(String cardName, int cardID, EnergyType energyType) {
        super(cardName, CardType.Pokemon , cardID);
        this.energyType = energyType;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }
}
