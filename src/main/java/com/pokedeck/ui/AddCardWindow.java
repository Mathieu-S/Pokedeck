package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AddCardWindow extends JFrame {

    //Attributes window
    private JPanel panel1;
    private JTextField cardNameField;
    private JComboBox cardTypeField;
    private JSpinner cardIDField;
    private JComboBox pokemonTypeField;
    private JSpinner pokemonHPField;
    private JSpinner pokemonEvoStageField;
    private JComboBox pokemonEvoFromField;
    private JComboBox trainerTypeField;
    private JComboBox energyTypeField;
    private JButton createCardButton;

    //Other Attributes
    private DefaultListModel cards;
    Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);


    public AddCardWindow(final DefaultListModel cards) {

        this.cards = cards;

        //Initilize basic window informations
        this.setContentPane(panel1);
        this.setTitle("Add a card");
        this.setLocationRelativeTo(null);

        cardTypeField.setModel(new DefaultComboBoxModel(CardType.values()));
        pokemonTypeField.setModel(new DefaultComboBoxModel(EnergyType.values()));
        trainerTypeField.setModel(new DefaultComboBoxModel(TrainerType.values()));
        energyTypeField.setModel(new DefaultComboBoxModel(EnergyType.values()));


        createCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.add(cards.getSize(),card1.getCardName());
                dispose();
            }
        });

        // close window
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
