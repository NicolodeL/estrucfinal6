package Interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazConBotones extends JFrame {
    public InterfazConBotones() {
        setTitle("Interfaz con Botones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");

        add(boton1);
        add(boton2);
        add(boton3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazConBotones().setVisible(true);
            }
        });
    }
}
