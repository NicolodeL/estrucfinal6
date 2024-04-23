package MapayAsociacion;

import java.util.HashMap;
import java.util.Map;

public class Mapeado {
    public static void main(String[] args) {
        // Crear un mapa para asociar números con letras
        Map<Integer, Character> numberToLetter = new HashMap<>();
        numberToLetter.put(1, 'A');
        numberToLetter.put(2, 'B');
        numberToLetter.put(3, 'C');
        // ...

        // Crear un mapa para asociar números con sus representaciones textuales
        Map<Integer, String> numberToText = new HashMap<>();
        numberToText.put(1, "One");
        numberToText.put(2, "Two");
        numberToText.put(3, "Three");
        // ...

        // Ahora puedes usar estos mapas para gestionar las relaciones
        System.out.println(numberToLetter.get(1)); // Imprime: A
        System.out.println(numberToText.get(2)); // Imprime: Two
    }
}
