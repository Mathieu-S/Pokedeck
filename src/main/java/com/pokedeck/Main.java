package com.pokedeck;

import com.pokedeck.cards.*;
import java.util.ArrayList;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //Intro
        System.out.println("==================");
        System.out.println("==== PokeDeck ====");
        System.out.println("==================");
        System.out.println("");

        //Core
        ArrayList <Card> cards = new ArrayList <Card> ();
        
        Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);
        Card card2 = new TrainerCard("Pokeball", TrainerType.Item);
        
        cards.add(card);
        cards.add(card1);
        cards.add(card2);
        
        Window window = new Window(cards);
       
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
