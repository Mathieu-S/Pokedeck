package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    //Attributes window
    private JPanel jPanel;
    private JButton addCardButton;
    private JButton deleteCardButton;
    private JList jListCards;
    private JTable jTableCardList;
    private JButton editCardButton;

    //Attributes
    private String filename = "cards.ser";
    private ArrayList cards = new ArrayList();
    private DefaultListModel<String> listCards = new DefaultListModel<String>();

    public MainWindow() {

        //Initilize basic window informations
        this.setContentPane(jPanel);
        this.setTitle("PokeDeck");
        this.setLocationRelativeTo(null);

        //Try to load
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            cards = (ArrayList) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Aucune sauvegarde n'a été trouvée. Une nouvelle sera créer");
        }

        //Prepare items in JList
        for (int i = 0; i < cards.size() ; i++) {
            Card tempCard = (Card) cards.get(i);
            listCards.add(i, tempCard.getCardName());
        }
        jListCards.setModel(listCards);

        addCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditorCardWindow editorCardWindow = new EditorCardWindow(listCards, cards);
                editorCardWindow.pack();
                editorCardWindow.setSize(260,365);
                editorCardWindow.setVisible(true);
            }
        });

        editCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jListCards.getSelectedIndex() >= 0) {
                    EditorCardWindow editorCardWindow = new EditorCardWindow(listCards, cards, jListCards.getSelectedIndex());
                    editorCardWindow.pack();
                    editorCardWindow.setSize(260,365);
                    editorCardWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Vous n'avez selectionnez aucune carte");
                }
            }
        });

        deleteCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cards.remove(jListCards.getSelectedIndex());
                    listCards.remove(jListCards.getSelectedIndex());
                    jListCards.setModel(listCards);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Vous n'avez selectionnez aucune carte");
                }
            }
        });

        jListCards.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("DataType");
                defaultTableModel.addColumn("Value");
                Card typeCardSelected = (Card) cards.get(jListCards.getSelectedIndex());
                if (typeCardSelected.getType() == CardType.Pokemon) {
                    PokemonCard cardSelected = (PokemonCard) cards.get(jListCards.getSelectedIndex());
                    defaultTableModel.addRow(new String[]{"ID", String.valueOf(cardSelected.getCardID())});
                    defaultTableModel.addRow(new String[]{"Name", cardSelected.getCardName()});
                    defaultTableModel.addRow(new String[]{"Card Type", String.valueOf(cardSelected.getType())});
                    defaultTableModel.addRow(new String[]{"Pokemon Type", String.valueOf(cardSelected.getPokemonType())});
                    defaultTableModel.addRow(new String[]{"Health Points", String.valueOf(cardSelected.getHealthPoint())});
                    defaultTableModel.addRow(new String[]{"Evolution Stage", String.valueOf(cardSelected.getEvolutionStage())});
                    defaultTableModel.addRow(new String[]{"Evolve From", String.valueOf(cardSelected.getEvolveFrom().getCardName())});
                } else if (typeCardSelected.getType() == CardType.Trainer) {
                    TrainerCard cardSelected = (TrainerCard) cards.get(jListCards.getSelectedIndex());
                    defaultTableModel.addRow(new String[]{"ID", String.valueOf(cardSelected.getCardID())});
                    defaultTableModel.addRow(new String[]{"Name", cardSelected.getCardName()});
                    defaultTableModel.addRow(new String[]{"Card Type", String.valueOf(cardSelected.getType())});
                    defaultTableModel.addRow(new String[]{"Trainer Type", String.valueOf(cardSelected.getTrainerType())});
                } else if (typeCardSelected.getType() == CardType.Energy) {
                    EnergyCard cardSelected = (EnergyCard) cards.get(jListCards.getSelectedIndex());
                    defaultTableModel.addRow(new String[]{"ID", String.valueOf(cardSelected.getCardID())});
                    defaultTableModel.addRow(new String[]{"Name", cardSelected.getCardName()});
                    defaultTableModel.addRow(new String[]{"Card Type", String.valueOf(cardSelected.getType())});
                    defaultTableModel.addRow(new String[]{"Energy Type", String.valueOf(cardSelected.getEnergyType())});
                }
                jTableCardList.setModel(defaultTableModel);
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
                    out.writeObject(cards);
                    out.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Une erreur c'est produite et vos données n'ont pas été sauvegardées");
                }
                dispose();
            }
        });
    }
}
