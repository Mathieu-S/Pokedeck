package com.pokedeck;

import javax.swing.*;

public class Window extends JFrame{

    public Window(){
        this.setTitle("Pokedeck");
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");

        JComponent list = new JList(listModel);

        this.add(list);

    }
}
