package com.pokedeck;

import com.pokedeck.cards.Card;
import com.pokedeck.cards.CardType;
import com.pokedeck.cards.EnergyCard;
import com.pokedeck.cards.EnergyType;

public class Main {

    public static void main(String[] args) {
        //Intro
        System.out.println("==================");
        System.out.println("==== PokeDeck ====");
        System.out.println("==================");
        System.out.println("");

        //Core
        Card card = new EnergyCard("Eau", CardType.Energy, EnergyType.Water);
        System.out.println(card.getCardName());
        System.out.println(card.getType());
    }
}
