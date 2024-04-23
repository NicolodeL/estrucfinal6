package IndexacionyVisualizacion;

import java.io.File;
import java.util.*;

public class OrdenArchivos {
    private Map<String, String> indice;

    public OrdenArchivos() {
        indice = new HashMap<>();
    }

    public void indexarDirectorio(String directorio) {
        File dir = new File(directorio);
        File[] archivos = dir.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    indexarDirectorio(archivo.getPath());
                } else {
                    indice.put(archivo.getName(), archivo.getPath());
                }
            }
        }
    }

    public List<String> listarArchivosOrdenados() {
        List<String> listaOrdenada = new ArrayList<>();
        List<String> nombresArchivos = new ArrayList<>(indice.keySet());
        Collections.sort(nombresArchivos);
        for (String nombreArchivo : nombresArchivos) {
            listaOrdenada.add(nombreArchivo + " - " + indice.get(nombreArchivo));
        }
        return listaOrdenada;
    }
}
