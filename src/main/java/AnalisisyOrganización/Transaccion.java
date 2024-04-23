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

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
// Getters y setters para cada atributo
    // ...
}
