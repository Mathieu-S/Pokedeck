package com.pokedeck;

import com.pokedeck.ui.MainWindow;

public class Main {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.pack();
        mainWindow.setSize(600,450);
        mainWindow.setVisible(true);
    }
}
