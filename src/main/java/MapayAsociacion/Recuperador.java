package MapayAsociacion;

import java.util.HashMap;
import java.util.Map;

public class Recuperador {
    private Map<String, String> datos;

    public Recuperador() {
        datos = new HashMap<>();
    }

    public void agregarDato(String clave, String valor) {
        datos.put(clave, valor);
    }

    public String recuperarDato(String clave) {
        return datos.get(clave);
    }
}