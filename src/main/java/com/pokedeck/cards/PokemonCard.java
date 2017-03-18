package com.pokedeck.cards;

/**
 * Class PokemonCard, extend the Class Card
 */
public class PokemonCard extends Card{

    private EnergyType pokemonType;
    private int healthPoint;
    private int evolutionStage = 0;
    private PokemonCard evolveFrom = null;

    /**
     * Create a simplified PokemonCard
     * @param cardName Define the name of the pokemon
     * @param pokemonType Define the type of energy. Use Enum form EnergyType
     * @param healthPoint Define the health points of the pokemon
     */
    public PokemonCard(String cardName, EnergyType pokemonType, int healthPoint) {
        super(cardName, CardType.Pokemon, 0);
        this.pokemonType = pokemonType;
        this.healthPoint = healthPoint;
    }

    /**
     * Create a PokemonCard
     * @param cardName Define the name of the pokemon
     * @param cardID Define the ID of the card
     * @param pokemonType Define the type of energy. Use Enum form EnergyType
     * @param healthPoint Define the health points of the pokemon
     * @param evolutionStage Define the evolution stage of the pokemon
     * @param evolveFrom Define the pre-evolution of the pokemon
     */
    public PokemonCard(String cardName, int cardID, EnergyType pokemonType, int healthPoint, int evolutionStage, PokemonCard evolveFrom) {
        super(cardName, CardType.Pokemon , cardID);
        this.pokemonType = pokemonType;
        this.healthPoint = healthPoint;
        this.evolutionStage = evolutionStage;
        this.evolveFrom = evolveFrom;
    }

    /**
     * Get the type of energy of the pokemon
     * @return EnergyType of pokemon
     */
    public EnergyType getPokemonType() {
        return pokemonType;
    }

    /**
     * Set the type of energy of the pokemon
     * @param pokemonType EnergyType Enum
     */
    public void setPokemonType(EnergyType pokemonType) {
        this.pokemonType = pokemonType;
    }

    /**
     * Get the health points of the pokemon
     * @return int health points
     */
    public int getHealthPoint() {
        return healthPoint;
    }

    /**
     * Set the health points of the pokemon
     * @param healthPoint int health points
     */
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    /**
     * Get the evolution stage of the pokemon
     * @return int evolution stage
     */
    public int getEvolutionStage() {
        return evolutionStage;
    }

    /**
     * Set the evolution stage of the pokemon
     * @param evolutionStage int evolution stage
     */
    public void setEvolutionStage(int evolutionStage) {
        this.evolutionStage = evolutionStage;
    }

    /**
     * Get the pre-evolution of the pokemon
     * @return PokemonCard
     */
    public PokemonCard getEvolveFrom() {
        return evolveFrom;
    }

    /**
     * Set the pre-evolution of the pokemon
     * @param evolveFrom PokemonCard
     */
    public void setEvolveFrom(PokemonCard evolveFrom) {
        this.evolveFrom = evolveFrom;
    }
}
