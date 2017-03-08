package com.pokedeck;

import com.pokedeck.cards.*;
import com.pokedeck.ui.MainWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {

    public static void main(String[] args) {
        //Test Cards
        Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);
        Card card2 = new TrainerCard("Pokeball", TrainerType.Item);
        Object [] cards = {card.getCardName(), card.getType()};

        MainWindow mainWindow = new MainWindow();
        mainWindow.pack();
        mainWindow.setSize(600,450);
        mainWindow.setVisible(true);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Object [] entetes = {"Name", "Type"};
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Type");
        defaultTableModel.setColumnIdentifiers(entetes);
        defaultTableModel.addRow(cards);

        mainWindow.getTable1().setModel(defaultTableModel);
    }
}
