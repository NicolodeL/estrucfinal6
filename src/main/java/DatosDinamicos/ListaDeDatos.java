package DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class ListaDeDatos {
    private List<Dato> datos;

    public ListaDeDatos() {
        this.datos = new ArrayList<>();
    }

    public void addDato(Dato dato) {
        this.datos.add(dato);
    }

    public List<Dato> getDatos() {
        return datos;
    }
}