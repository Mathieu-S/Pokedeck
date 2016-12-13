package com.pokedeck;

import com.pokedeck.cards.Card;

public class Main {

    public static void main(String[] args) {
        //Intro
        System.out.println("==================");
        System.out.println("==== PokeDeck ====");
        System.out.println("==================");
        System.out.println("");

        //Core
        Card card = new Card("Test","None");
        System.out.println(card.getCardName());
    }
}
