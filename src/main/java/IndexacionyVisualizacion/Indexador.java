package IndexacionyVisualizacion;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Indexador {
    private Map<String, String> indice;

    public Indexador() {
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

    public String buscarArchivo(String nombreArchivo) {
        return indice.get(nombreArchivo);
    }

    public Map<String, String> getIndice() {
        return indice;
    }
}
