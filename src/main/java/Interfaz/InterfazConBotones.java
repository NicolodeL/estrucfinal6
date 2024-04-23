package Interfaz;

import DatosDinamicos.Dato;
import DatosDinamicos.ListaDeDatos;
import DatosDinamicos.Pareja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazConBotones extends JFrame {
    private JTextField fieldDatoReal;
    private JTextField fieldFirst;
    private JTextField fieldSecond;
    private ListaDeDatos listaDeDatos;
    private JButton buttonAdd;

    public InterfazConBotones() {
        listaDeDatos = new ListaDeDatos();

        setLayout(new FlowLayout());

        JButton buttonDatos = new JButton("Datos");
        buttonDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDataEntryDialog();
            }
        });
        add(buttonDatos);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showDataEntryDialog() {
        JDialog dialog = new JDialog(this, "Ingresar datos", true);
        dialog.setLayout(new FlowLayout());

        fieldDatoReal = new JTextField(10);
        dialog.add(fieldDatoReal);

        fieldFirst = new JTextField(10);
        dialog.add(fieldFirst);

        fieldSecond = new JTextField(10);
        dialog.add(fieldSecond);

        buttonAdd = new JButton("Agregar dato");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double datoReal = Double.parseDouble(fieldDatoReal.getText());
                int first = Integer.parseInt(fieldFirst.getText());
                int second = Integer.parseInt(fieldSecond.getText());

                Pareja pareja = new Pareja(first, second);
                Dato dato = new Dato(datoReal, pareja);

                listaDeDatos.addDato(dato);

                fieldDatoReal.setText("");
                fieldFirst.setText("");
                fieldSecond.setText("");
            }
        });
        dialog.add(buttonAdd);

        dialog.pack();
        dialog.setVisible(true);
    }
}
