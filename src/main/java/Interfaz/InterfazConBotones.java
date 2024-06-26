package Interfaz;

import AnalisisyOrganización.Ordenar;
import AnalisisyOrganización.RegistroTransacciones;
import AnalisisyOrganización.Transaccion;
import DatosDinamicos.Dato;
import DatosDinamicos.ListaDeDatos;
import DatosDinamicos.Pareja;
import MapayAsociacion.Mapeado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import MapayAsociacion.Recuperador;
import IndexacionyVisualizacion.Indexador;
import IndexacionyVisualizacion.OrdenArchivos;

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
    private RegistroTransacciones registroTransacciones;
    private JButton buttonSortByDate;
    private JButton buttonSortByAmount;
    private JButton buttonFilterByClient;

    private JButton buttonShowMappings;
    private JButton buttonIndexDirectory;
    private JButton buttonSearchFile;
    private JTextField fieldDirectory;
    private JTextField fieldFileName;
    private Indexador indexador;
    private JList<Transaccion> transactionList;
    private JButton buttonListFilesOrden;
    private OrdenArchivos ordenArchivos;

    private JTextField fieldIdTransaccion;
    private JTextField fieldFecha;
    private JTextField fieldMonto;
    private JTextField fieldIdCliente;
    private JButton buttonAddTransaction;
    private JButton buttonRetrieveData;
    private JTextField fieldKey;
    private Recuperador recuperador;


    public InterfazConBotones() {
        listaDeDatos = new ListaDeDatos();
        registroTransacciones = new RegistroTransacciones();

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

        buttonSortByDate = new JButton("Ordenar transacciones por Fecha");
        buttonSortByDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroTransacciones.ordenarPorFecha();
                updateTransactionList();
            }
        });
        add(buttonSortByDate);

        buttonSortByAmount = new JButton("Ordenar transacciones por Monto");
        buttonSortByAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroTransacciones.ordenarPorMonto();
                updateTransactionList();
            }
        });
        add(buttonSortByAmount);

        buttonFilterByClient = new JButton("Filtrar transacciones por Cliente");
        buttonFilterByClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes reemplazar '1' con el ID del cliente que deseas filtrar
                List<Transaccion> filteredTransactions = registroTransacciones.filtrarPorCliente(1);
                updateTransactionList(filteredTransactions);
            }
        });
        add(buttonFilterByClient);

        fieldIdTransaccion = new JTextField(10);
        add(fieldIdTransaccion);

        fieldFecha = new JTextField(10);
        add(fieldFecha);

        fieldMonto = new JTextField(10);
        add(fieldMonto);

        fieldIdCliente = new JTextField(10);
        add(fieldIdCliente);

        buttonAddTransaction = new JButton("Agregar transacción");
        buttonAddTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idTransaccion = Integer.parseInt(fieldIdTransaccion.getText());
                // Aquí asumimos que la fecha se introduce en el formato "yyyy-MM-dd"
                Date fecha = java.sql.Date.valueOf(fieldFecha.getText());
                double monto = Double.parseDouble(fieldMonto.getText());
                int idCliente = Integer.parseInt(fieldIdCliente.getText());

                Transaccion transaccion = new Transaccion(idTransaccion, fecha, monto, idCliente);
                registroTransacciones.agregarTransaccion(transaccion);
                updateTransactionList();

                fieldIdTransaccion.setText("");
                fieldFecha.setText("");
                fieldMonto.setText("");
                fieldIdCliente.setText("");
            }
        });
        add(buttonAddTransaction);

        recuperador = new Recuperador();

        fieldKey = new JTextField(10);
        add(fieldKey);

        buttonRetrieveData = new JButton("Recuperar dato");
        buttonRetrieveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = fieldKey.getText();
                String value = recuperador.recuperarDato(key);
                JOptionPane.showMessageDialog(null, "El valor asociado a la clave '" + key + "' es: " + value);
            }
        });
        add(buttonRetrieveData);

        buttonShowMappings = new JButton("Mostrar mapeos");
        buttonShowMappings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mapeado mapeado = new Mapeado();
                mapeado.showMappings();
            }
        });
        add(buttonShowMappings);

        indexador = new Indexador();

        fieldDirectory = new JTextField(10);
        add(fieldDirectory);

        buttonIndexDirectory = new JButton("Indexar directorio");
        buttonIndexDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directory = fieldDirectory.getText();
                indexador.indexarDirectorio(directory);
                JOptionPane.showMessageDialog(null, "Directorio indexado con éxito");
            }
        });
        add(buttonIndexDirectory);

        fieldFileName = new JTextField(10);
        add(fieldFileName);

        buttonSearchFile = new JButton("Buscar archivo");
        buttonSearchFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fieldFileName.getText();
                String filePath = indexador.buscarArchivo(fileName);
                if (filePath != null) {
                    JOptionPane.showMessageDialog(null, "El archivo '" + fileName + "' se encuentra en: " + filePath);
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo '" + fileName + "' no se encuentra en el índice");
                }
            }
        });
        add(buttonSearchFile);


        ordenArchivos = new OrdenArchivos();

        buttonListFilesOrden = new JButton("Listar archivos ordenados");
        buttonListFilesOrden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> archivosOrdenados = ordenArchivos.listarArchivosOrdenados();
                String mensaje = String.join("\n", archivosOrdenados);
                JOptionPane.showMessageDialog(null, mensaje);
            }
        });
        add(buttonListFilesOrden);

        transactionList = new JList<>();
        add(new JScrollPane(transactionList));

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

    private void updateTransactionList() {
        DefaultListModel<Transaccion> model = new DefaultListModel<>();
        for (Transaccion transaccion : registroTransacciones.getTransacciones()) {
            model.addElement(transaccion);
        }
        transactionList.setModel(model);
    }

    private void updateTransactionList(List<Transaccion> transactions) {
        DefaultListModel<Transaccion> model = new DefaultListModel<>();
        for (Transaccion transaccion : transactions) {
            model.addElement(transaccion);
        }
        transactionList.setModel(model);
    }
}