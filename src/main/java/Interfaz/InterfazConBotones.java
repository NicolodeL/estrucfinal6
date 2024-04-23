package Interfaz;

import AnalisisyOrganización.Ordenar;
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
    private JButton buttonSort;
    private JPopupMenu sortMenu;
    private JList<Dato> dataList;

    public InterfazConBotones() {
        listaDeDatos = new ListaDeDatos();

        setLayout(new FlowLayout());

        fieldDatoReal = new JTextField(10);
        add(fieldDatoReal);

        fieldFirst = new JTextField(10);
        add(fieldFirst);

        fieldSecond = new JTextField(10);
        add(fieldSecond);

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
        add(buttonAdd);

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
        add(buttonDelete);

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
        add(buttonModify);

        buttonSort = new JButton("Ordenar");
        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortMenu.show(buttonSort, buttonSort.getWidth() / 2, buttonSort.getHeight() / 2);
            }
        });
        add(buttonSort);

        sortMenu = new JPopupMenu();

        JMenuItem sortByDatoReal = new JMenuItem("Ordenar por Valor Real");
        sortByDatoReal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ordenar.ordenarPorDatoReal(listaDeDatos);
                updateDataList();
            }
        });
        sortMenu.add(sortByDatoReal);

        JMenuItem sortByFirst = new JMenuItem("Ordenar por Primer Valor de Pareja");
        sortByFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ordenar.ordenarPorFirst(listaDeDatos);
                updateDataList();
            }
        });
        sortMenu.add(sortByFirst);

        JMenuItem sortBySecond = new JMenuItem("Ordenar por Segundo Valor de Pareja");
        sortBySecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ordenar.ordenarPorSecond(listaDeDatos);
                updateDataList();
            }
        });
        sortMenu.add(sortBySecond);

        dataList = new JList<>();
        add(new JScrollPane(dataList));

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateDataList() {
        DefaultListModel<Dato> model = new DefaultListModel<>();
        for (Dato dato : listaDeDatos.getDatos()) {
            model.addElement(dato);
        }
        dataList.setModel(model);
    }
}