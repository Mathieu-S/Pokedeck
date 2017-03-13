package com.pokedeck.ui;

import com.pokedeck.cards.*;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
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

        final DefaultListModel<String> defaultListModel = new DefaultListModel<String>();


        //Try to load
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            serializeCards = (ArrayList) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Aucune sauvegarde n'a été trouvée. Une nouvelle sera créer");
        }

        for (int i = 0; i < serializeCards.size() ; i++) {
            Card tempCard = (Card) serializeCards.get(i);
            defaultListModel.add(i, tempCard.getCardName());
        }
        cardList.setModel(defaultListModel);

//        Object [] cards = {card.getCardName(), card.getType()};
//        DefaultTableModel defaultTableModel = new DefaultTableModel();
//        Object [] entetes = {"Name", "Type"};
//        defaultTableModel.addColumn("Name");
//        defaultTableModel.addColumn("Type");
//        defaultTableModel.setColumnIdentifiers(entetes);
//        defaultTableModel.addRow(cards);
//
//        this.table1.setModel(defaultTableModel);

        addCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddCardWindow addCardWindow = new AddCardWindow(defaultListModel, serializeCards);
                addCardWindow.pack();
                addCardWindow.setSize(260,365);
                addCardWindow.setVisible(true);
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
