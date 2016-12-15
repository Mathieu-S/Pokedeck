package com.pokedeck.cards;

public class EnergyCard extends Card{

    private EnergyType energyType;

    public EnergyCard(String cardName, CardType type, EnergyType energyType) {
        super(cardName, type);
        this.energyType = energyType;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }
}
