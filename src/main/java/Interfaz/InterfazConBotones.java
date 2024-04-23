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
    private JButton buttonDelete;
    private JButton buttonModify;
    private JList<Dato> dataList;

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

        dataList = new JList<>();
        add(new JScrollPane(dataList));

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
                updateDataList();

                fieldDatoReal.setText("");
                fieldFirst.setText("");
                fieldSecond.setText("");
            }
        });
        dialog.add(buttonAdd);

        buttonDelete = new JButton("Eliminar dato");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato selectedDato = dataList.getSelectedValue();
                if (selectedDato != null) {
                    listaDeDatos.getDatos().remove(selectedDato);
                    updateDataList();
                }
            }
        });
        dialog.add(buttonDelete);

        buttonModify = new JButton("Modificar dato");
        buttonModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dato selectedDato = dataList.getSelectedValue();
                if (selectedDato != null) {
                    double datoReal = Double.parseDouble(fieldDatoReal.getText());
                    int first = Integer.parseInt(fieldFirst.getText());
                    int second = Integer.parseInt(fieldSecond.getText());

                    selectedDato.setDatoReal(datoReal);
                    selectedDato.getPareja().setFirst(first);
                    selectedDato.getPareja().setSecond(second);

                    updateDataList();
                }
            }
        });
        dialog.add(buttonModify);

        dialog.pack();
        dialog.setVisible(true);
    }

    private void updateDataList() {
        DefaultListModel<Dato> model = new DefaultListModel<>();
        for (Dato dato : listaDeDatos.getDatos()) {
            model.addElement(dato);
        }
        dataList.setModel(model);
    }
}