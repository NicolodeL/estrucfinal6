package AnalisisyOrganización;

import DatosDinamicos.Dato;
import DatosDinamicos.ListaDeDatos;

import java.util.Comparator;
import java.util.List;

public class Ordenar {

    public static void ordenarPorDatoReal(ListaDeDatos listaDeDatos) {
        List<Dato> datos = listaDeDatos.getDatos();
        datos.sort(Comparator.comparing(Dato::getDatoReal));
    }

    public static void ordenarPorFirst(ListaDeDatos listaDeDatos) {
        List<Dato> datos = listaDeDatos.getDatos();
        datos.sort(Comparator.comparing(dato -> dato.getPareja().getFirst()));
    }

    public static void ordenarPorSecond(ListaDeDatos listaDeDatos) {
        List<Dato> datos = listaDeDatos.getDatos();
        datos.sort(Comparator.comparing(dato -> dato.getPareja().getSecond()));
    }
}
