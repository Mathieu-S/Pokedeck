package com.pokedeck;

import com.pokedeck.cards.*;
import com.pokedeck.ui.MainWindow;

public class Main {

    public static void main(String[] args) {
        //Test Cards
        Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);
        Card card2 = new TrainerCard("Pokeball", TrainerType.Item);

        MainWindow mainWindow = new MainWindow();
        mainWindow.pack();
        mainWindow.setSize(600,450);
        mainWindow.setVisible(true);
    }
}
