package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditorCardWindow extends JDialog {

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
    private int selectedCard;

    public EditorCardWindow(final DefaultListModel listCards, final ArrayList<Card> cards) {
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

        this.pokemonEvoFromField.addItem("None");
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
                        if (pokemonEvoFromField.getSelectedItem() == "None") {
                            PokemonCard pokemonCardNull = new PokemonCard("None", EnergyType.Darkness, 0);
                            cards.add(new PokemonCard(cardNameField.getText(),
                                    (Integer) cardIDField.getValue(),
                                    (EnergyType) pokemonTypeField.getSelectedItem(),
                                    (Integer) pokemonHPField.getValue(),
                                    (Integer) pokemonEvoStageField.getValue(),
                                    pokemonCardNull));
                        } else {
                            cards.add(new PokemonCard(cardNameField.getText(),
                                    (Integer) cardIDField.getValue(),
                                    (EnergyType) pokemonTypeField.getSelectedItem(),
                                    (Integer) pokemonHPField.getValue(),
                                    (Integer) pokemonEvoStageField.getValue(),
                                    (PokemonCard) cards.get(pokemonEvoFromField.getSelectedIndex() - 1)));
                        }
                    } else if (cardTypeField.getSelectedItem() == CardType.Trainer) {
                        cards.add(new TrainerCard(cardNameField.getText(),
                                (Integer) cardIDField.getValue(),
                                (TrainerType) trainerTypeField.getSelectedItem()));
                    } else if (cardTypeField.getSelectedItem() == CardType.Energy) {
                        cards.add(new EnergyCard(cardNameField.getText(),
                                (Integer) cardIDField.getValue(),
                                (EnergyType) energyTypeField.getSelectedItem()));
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Merci de remplir le nom de la carte au minimum");
                }
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

        // close window
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public EditorCardWindow(final DefaultListModel listCards, final ArrayList<Card> cards, final int selectedCard) {
        this.listCards = listCards;
        this.cards = cards;
        this.selectedCard = selectedCard;

        //Initialize basic window informations
        this.setContentPane(panel1);
        this.setTitle("Add a card");
        this.setLocationRelativeTo(null);
        this.createCardButton.setText("Edit Card");

        //Initialize ComboBox
        this.cardTypeField.setModel(new DefaultComboBoxModel(CardType.values()));
        this.pokemonTypeField.setModel(new DefaultComboBoxModel(EnergyType.values()));
        this.trainerTypeField.setModel(new DefaultComboBoxModel(TrainerType.values()));
        this.energyTypeField.setModel(new DefaultComboBoxModel(EnergyType.values()));

        this.pokemonEvoFromField.addItem("None");
        for (Card card : cards) {
            if (card.getType() == CardType.Pokemon) {
                this.pokemonEvoFromField.addItem(card.getCardName());
            }
        }

        //Initialize Fields
        this.trainerTypeField.setEnabled(false);
        this.energyTypeField.setEnabled(false);

        Card typeCardSelected = (Card) cards.get(selectedCard);
        if (typeCardSelected.getType() == CardType.Pokemon) {
            PokemonCard cardSelected = (PokemonCard) cards.get(selectedCard);
            System.out.println(cardSelected.getEvolveFrom().getCardName());
            this.cardNameField.setText(cardSelected.getCardName());
            this.cardIDField.setValue(cardSelected.getCardID());
            this.cardTypeField.setSelectedItem(cardSelected.getType());
            this.pokemonTypeField.setSelectedItem(cardSelected.getPokemonType());
            this.pokemonHPField.setValue(cardSelected.getHealthPoint());
            this.pokemonEvoStageField.setValue(cardSelected.getEvolutionStage());
            this.pokemonTypeField.setSelectedItem(cardSelected.getEvolveFrom().getCardName());
        } else if (typeCardSelected.getType() == CardType.Trainer) {
            TrainerCard cardSelected = (TrainerCard) cards.get(selectedCard);
            this.pokemonTypeField.setEnabled(false);
            this.pokemonHPField.setEnabled(false);
            this.pokemonEvoStageField.setEnabled(false);
            this.pokemonEvoFromField.setEnabled(false);
            this.trainerTypeField.setEnabled(true);
            this.energyTypeField.setEnabled(false);
            this.cardNameField.setText(cardSelected.getCardName());
            this.cardIDField.setValue(cardSelected.getCardID());
            this.cardTypeField.setSelectedItem(cardSelected.getType());
            this.trainerTypeField.setSelectedItem(cardSelected.getTrainerType());
        } else if (typeCardSelected.getType() == CardType.Energy) {
            EnergyCard cardSelected = (EnergyCard) cards.get(selectedCard);
            this.pokemonTypeField.setEnabled(false);
            this.pokemonHPField.setEnabled(false);
            this.pokemonEvoStageField.setEnabled(false);
            this.pokemonEvoFromField.setEnabled(false);
            this.trainerTypeField.setEnabled(false);
            this.energyTypeField.setEnabled(true);
            this.cardNameField.setText(cardSelected.getCardName());
            this.cardIDField.setValue(cardSelected.getCardID());
            this.cardTypeField.setSelectedItem(cardSelected.getType());
            this.energyTypeField.setSelectedItem(cardSelected.getEnergyType());
        }

        createCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cardNameField.getText().length()>0) {
                    listCards.set(selectedCard,cardNameField.getText());
                    if (cardTypeField.getSelectedItem() == CardType.Pokemon) {
                        if (pokemonEvoFromField.getSelectedItem() == "None") {
                            PokemonCard pokemonCardNull = new PokemonCard("None", EnergyType.Darkness, 0);
                            cards.set(selectedCard, new PokemonCard(cardNameField.getText(),
                                    (Integer) cardIDField.getValue(),
                                    (EnergyType) pokemonTypeField.getSelectedItem(),
                                    (Integer) pokemonHPField.getValue(),
                                    (Integer) pokemonEvoStageField.getValue(),
                                    pokemonCardNull));
                        } else {
                            cards.set(selectedCard, new PokemonCard(cardNameField.getText(),
                                    (Integer) cardIDField.getValue(),
                                    (EnergyType) pokemonTypeField.getSelectedItem(),
                                    (Integer) pokemonHPField.getValue(),
                                    (Integer) pokemonEvoStageField.getValue(),
                                    (PokemonCard) cards.get(pokemonEvoFromField.getSelectedIndex() - 1)));
                        }
                    } else if (cardTypeField.getSelectedItem() == CardType.Trainer) {
                        cards.set(selectedCard, new TrainerCard(cardNameField.getText(),
                                (Integer) cardIDField.getValue(),
                                (TrainerType) trainerTypeField.getSelectedItem()));
                    } else if (cardTypeField.getSelectedItem() == CardType.Energy) {
                        cards.set(selectedCard, new EnergyCard(cardNameField.getText(),
                                (Integer) cardIDField.getValue(),
                                (EnergyType) energyTypeField.getSelectedItem()));
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Merci de remplir le nom de la carte au minimum");
                }
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

        // close window
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
