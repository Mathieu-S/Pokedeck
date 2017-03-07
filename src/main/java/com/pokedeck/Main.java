package com.pokedeck;

import com.pokedeck.cards.*;
import com.pokedeck.ui.MainWindow;

public class Main {

    public static void main(String[] args) {
        //Intro
        System.out.println("==================");
        System.out.println("==== PokeDeck ====");
        System.out.println("==================");
        System.out.println("");

        //Core
        Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);
        Card card2 = new TrainerCard("Pokeball", TrainerType.Item);

        System.out.println(card.getCardName());
        System.out.println(card.getType());
        System.out.println("");
        System.out.println(card1.getCardName());
        System.out.println(card1.getType());
        System.out.println("");
        System.out.println(card2.getCardName());
        System.out.println(card2.getType());

        MainWindow mainWindow = new MainWindow();
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setTitle("PokeDeck");
        mainWindow.setSize(600,450);
        mainWindow.setVisible(true);
    }
}
