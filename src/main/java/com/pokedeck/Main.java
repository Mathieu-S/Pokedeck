package com.pokedeck;

import com.pokedeck.cards.*;

public class Main {

    public static void main(String[] args) {
        //Intro
        System.out.println("==================");
        System.out.println("==== PokeDeck ====");
        System.out.println("==================");
        System.out.println("");

        //Core
        Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou");
        Card card2 = new TrainerCard("Pokeball");

        System.out.println(card.getCardName());
        System.out.println(card.getType());
        System.out.println("");
        System.out.println(card1.getCardName());
        System.out.println(card1.getType());
        System.out.println("");
        System.out.println(card2.getCardName());
        System.out.println(card2.getType());
    }
}
