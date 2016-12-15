package com.pokedeck.cards;

public class EnergyCard extends Card{

    private EnergyType energyType;

    public EnergyCard(String cardName, EnergyType energyType) {
        super(cardName, CardType.Energy);
        this.energyType = energyType;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }
}
