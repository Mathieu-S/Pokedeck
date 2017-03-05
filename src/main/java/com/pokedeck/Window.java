package com.pokedeck;

import com.pokedeck.cards.*;
import java.util.ArrayList;
import javax.swing.*;

public class Window extends JFrame{

    public Window(ArrayList<Card> cards){
        this.setTitle("Pokedeck");
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        DefaultListModel listModel = new DefaultListModel();
        
        for (Card c : cards) {
        	listModel.addElement(c.getCardName());
        }
        
        JComponent list = new JList(listModel);
        
        this.add(list);
    }
}
