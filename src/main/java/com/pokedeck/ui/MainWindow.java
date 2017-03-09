package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    //Attributes window
    private JPanel panel1;
    private JButton addCardButton;
    private JButton deleteCardButton;
    private JList cardList;
    private JTable table1;

    //Attributes
    private String filename = "cards.ser";
    private ArrayList serializeCards = new ArrayList();

    public MainWindow() {

        //Initilize basic window informations
        this.setContentPane(panel1);
        this.setTitle("PokeDeck");
        this.setLocationRelativeTo(null);

        final Card card = new EnergyCard("Eau", EnergyType.Water);
        Card card1 = new PokemonCard("Rondoudou", EnergyType.Fairy, 50);
        final Card card2 = new TrainerCard("Pokeball", TrainerType.Item);

        final DefaultListModel<String> defaultListModel = new DefaultListModel<String>();


        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            serializeCards = (ArrayList) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < serializeCards.size() ; i++) {
            Card tempCard = (Card) serializeCards.get(i);
            defaultListModel.add(i, tempCard.getCardName());
        }
        cardList.setModel(defaultListModel);


        addCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                defaultListModel.add(defaultListModel.getSize(),card2.getCardName());
                serializeCards.add(card2);
            }
        });

        deleteCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    serializeCards.remove(cardList.getSelectedIndex());
                    defaultListModel.remove(cardList.getSelectedIndex());
                    cardList.setModel(defaultListModel);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Vous n'avez selectionnez aucune carte");
                }
            }
        });

        cardList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(cardList.getSelectedIndex());
            }
        });

        // Stop program when close window
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // save the object to file
                FileOutputStream fos = null;
                ObjectOutputStream out = null;
                try {
                    fos = new FileOutputStream(filename);
                    out = new ObjectOutputStream(fos);
                    out.writeObject(serializeCards);

                    out.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Une erreur c'est produite et vos données n'ont pas été sauvegardées");
                }
                dispose();
            }
        });
    }

    public JTable getTable1() {
        return table1;
    }
}
