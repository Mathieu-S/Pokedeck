package com.pokedeck.cards;

public class PokemonCard extends Card{

    private EnergyType pokemonType;
    private int healthPoint;
    private int evolutionStage = 0;
    private PokemonCard evolveFrom = null;

    public PokemonCard(String cardName, int cardID, EnergyType pokemonType, int healthPoint, int evolutionStage, PokemonCard evolveFrom) {
        super(cardName, CardType.Pokemon , cardID);
        this.pokemonType = pokemonType;
        this.healthPoint = healthPoint;
        this.evolutionStage = evolutionStage;
        this.evolveFrom = evolveFrom;
    }

    public EnergyType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(EnergyType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getEvolutionStage() {
        return evolutionStage;
    }

    public void setEvolutionStage(int evolutionStage) {
        this.evolutionStage = evolutionStage;
    }

    public PokemonCard getEvolveFrom() {
        return evolveFrom;
    }

    public void setEvolveFrom(PokemonCard evolveFrom) {
        this.evolveFrom = evolveFrom;
    }
}
