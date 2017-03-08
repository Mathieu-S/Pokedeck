package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends JFrame{

    private JPanel panel1;
    private JButton addCardButton;
    private JButton deleteCardButton;
    private JList cardList;
    private JTable table1;

    public MainWindow() {

        this.setContentPane(panel1);
        this.setTitle("PokeDeck");
        this.setLocationRelativeTo(null);

        Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);
        final Card card2 = new TrainerCard("Pokeball", TrainerType.Item);

        final DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
        defaultListModel.add(0, card.getCardName());
        defaultListModel.add(1, card1.getCardName());
        defaultListModel.add(2, card2.getCardName());
        cardList.setModel(defaultListModel);


        addCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                defaultListModel.add(defaultListModel.getSize(),card2.getCardName());
            }
        });

        deleteCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultListModel.remove(cardList.getSelectedIndex());
                    cardList.setModel(defaultListModel);
                } catch (ArrayIndexOutOfBoundsException e1) {
                    JOptionPane.showMessageDialog(null,"Vous n'avez selectionnez aucune carte");
                }
            }
        });

        cardList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.print(cardList.getSelectedIndex());
            }
        });





        // Stop program when close window
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });


    }

    public JList getCardList() {
        return cardList;
    }

    public JTable getTable1() {
        return table1;
    }
}
