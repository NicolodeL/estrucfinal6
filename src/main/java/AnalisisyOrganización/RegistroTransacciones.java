package AnalisisyOrganización;

import java.util.*;

public class RegistroTransacciones {
    private List<Transaccion> transacciones;

    public RegistroTransacciones() {
        this.transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
    }

    public void ordenarPorFecha() {
        Collections.sort(this.transacciones, Comparator.comparing(Transaccion::getFecha));
    }

    public void ordenarPorMonto() {
        Collections.sort(this.transacciones, Comparator.comparing(Transaccion::getMonto));
    }

    public List<Transaccion> filtrarPorCliente(int idCliente) {
        List<Transaccion> resultado = new ArrayList<>();
        for (Transaccion transaccion : this.transacciones) {
            if (transaccion.getIdCliente() == idCliente) {
                resultado.add(transaccion);
            }
        }
        return resultado;
    }


}
