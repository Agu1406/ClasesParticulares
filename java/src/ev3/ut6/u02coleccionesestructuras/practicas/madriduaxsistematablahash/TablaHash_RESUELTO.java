package ev3.ut6.u02coleccionesestructuras.practicas.madriduaxsistematablahash;
import java.util.HashMap;
import java.util.Map;

public class TablaHash_RESUELTO {
    // Funcion hash: fHash(k) = (k? - 1)
    private static int funcionHash(int k) {
        return (k * k - 1) % 7;
    }

    // Funcion para imprimir el estado de la tabla
    private static void imprimirTabla(Map<Integer, Integer> tabla) {
        System.out.println("\nEstado actual de la tabla:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Posicion " + i + ": ");
            if (tabla.containsKey(i)) {
                System.out.println(tabla.get(i));
            } else {
                System.out.println("vacia");
            }
        }
    }

    public static void main(String[] args) {
        // Crear tabla hash de tamano 7
        Map<Integer, Integer> tabla = new HashMap<>(7);
        
        // Valores a insertar
        int[] valores = {2, 6, 9, 8, 1};
        
        System.out.println("Insertando valores en la tabla hash...");
        for (int valor : valores) {
            int posicion = funcionHash(valor);
            System.out.println("\nInsertando valor: " + valor);
            System.out.println("Posicion calculada: " + posicion);
            
            // En HashMap, si hay colision, se maneja automaticamente
            tabla.put(posicion, valor);
            
            imprimirTabla(tabla);
        }
    }
} 
