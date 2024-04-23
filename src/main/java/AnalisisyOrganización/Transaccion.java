package AnalisisyOrganización;

import java.util.*;

public class Transaccion {
    private int idTransaccion;
    private Date fecha;
    private double monto;
    private int idCliente;

    public Transaccion(int idTransaccion, Date fecha, double monto, int idCliente) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    // Getters y setters para cada atributo
    // ...
}
