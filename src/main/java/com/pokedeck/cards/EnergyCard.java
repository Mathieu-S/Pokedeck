package com.pokedeck.cards;

/**
 * Class EnergyCard, extend the Class Card
 */
public class EnergyCard extends Card{

    private EnergyType energyType;

    /**
     * Create a new EnergyCard
     * @param cardName Define the name of the card
     * @param cardID Define the ID of the card
     * @param energyType Define the type of energy. Use Enum form EnergyType
     */
    public EnergyCard(String cardName, int cardID, EnergyType energyType) {
        super(cardName, CardType.Energy , cardID);
        this.energyType = energyType;
    }

    /**
     * Get the type of energy of the card
     * @return EnergyType of card
     */
    public EnergyType getEnergyType() {
        return energyType;
    }

    /**
     * Set the type of energy of the card
     * @param energyType EnergyType Enum
     */
    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }
}
