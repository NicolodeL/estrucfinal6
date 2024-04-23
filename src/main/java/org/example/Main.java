package org.example;

import Interfaz.InterfazConBotones;

import javax.swing.*;
//formato fecha para añadir transacciones YYYY-MM-DD
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazConBotones().setVisible(true);
            }
        });
    }
}