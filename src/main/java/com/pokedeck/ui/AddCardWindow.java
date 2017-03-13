package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddCardWindow extends JDialog {

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
    private DefaultListModel listCards;
    private ArrayList<Card> cards;

    public AddCardWindow(final DefaultListModel listCards, final ArrayList<Card> cards) {
        this.listCards = listCards;
        this.cards = cards;

        //Initialize basic window informations
        this.setContentPane(panel1);
        this.setTitle("Add a card");
        this.setLocationRelativeTo(null);

        //Initialize ComboBox
        this.cardTypeField.setModel(new DefaultComboBoxModel(CardType.values()));
        this.pokemonTypeField.setModel(new DefaultComboBoxModel(EnergyType.values()));
        this.trainerTypeField.setModel(new DefaultComboBoxModel(TrainerType.values()));
        this.energyTypeField.setModel(new DefaultComboBoxModel(EnergyType.values()));

        for (Card card : cards) {
            if (card.getType() == CardType.Pokemon) {
                this.pokemonEvoFromField.addItem(card.getCardName());
            }
        }

        //Initialize Fields
        this.trainerTypeField.setEnabled(false);
        this.energyTypeField.setEnabled(false);

        createCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardNameField.getText().length()>0) {
                    listCards.add(listCards.getSize(),cardNameField.getText());
                    if (cardTypeField.getSelectedItem() == CardType.Pokemon) {
                        cards.add(new PokemonCard(cardNameField.getText(), (EnergyType) pokemonTypeField.getSelectedItem(), (Integer) pokemonHPField.getValue()));
                    } else if (cardTypeField.getSelectedItem() == CardType.Trainer) {
                        cards.add(new TrainerCard(cardNameField.getText(), (TrainerType) trainerTypeField.getSelectedItem()));
                    } else if (cardTypeField.getSelectedItem() == CardType.Energy) {
                        cards.add(new EnergyCard(cardNameField.getText(), (EnergyType) energyTypeField.getSelectedItem()));
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Merci de remplir le nom de la carte au minimum");
                }
            }
        });

        // close window
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });


        cardTypeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardTypeField.getSelectedItem() == CardType.Pokemon) {
                    pokemonTypeField.setEnabled(true);
                    pokemonHPField.setEnabled(true);
                    pokemonEvoStageField.setEnabled(true);
                    pokemonEvoFromField.setEnabled(true);
                    trainerTypeField.setEnabled(false);
                    energyTypeField.setEnabled(false);
                } else if (cardTypeField.getSelectedItem() == CardType.Trainer) {
                    pokemonTypeField.setEnabled(false);
                    pokemonHPField.setEnabled(false);
                    pokemonEvoStageField.setEnabled(false);
                    pokemonEvoFromField.setEnabled(false);
                    trainerTypeField.setEnabled(true);
                    energyTypeField.setEnabled(false);
                } else if (cardTypeField.getSelectedItem() == CardType.Energy) {
                    pokemonTypeField.setEnabled(false);
                    pokemonHPField.setEnabled(false);
                    pokemonEvoStageField.setEnabled(false);
                    pokemonEvoFromField.setEnabled(false);
                    trainerTypeField.setEnabled(false);
                    energyTypeField.setEnabled(true);
                }
            }
        });
    }
}
