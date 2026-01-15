package madrid.iescanaveral.ejercicios.convocatoria2022.resueltos;

/**
 * Ejercicio 8: ¿Cuál es la salida del siguiente código? - RESUELTO
 * 
 * RESPUESTA: TRES
 * 
 * Explicación:
 * - a1 y a2 son objetos diferentes (aunque tengan el mismo valor), por lo que a1 == a2 es false
 * - a1 y a3 son objetos diferentes, por lo que a1 == a3 es false
 * - a3 = a2 hace que a3 apunte al mismo objeto que a2, por lo que a2 == a3 es true
 * - El operador == compara referencias, no valores
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio8_ComparacionObjetos_RESUELTO {
    static class MiClase {
        public int valor;
    }
    
    public static void main(String[] args) {
        MiClase a1 = new MiClase();
        MiClase a2 = new MiClase();
        MiClase a3 = new MiClase();
        
        a1.valor = 150;
        a2.valor = 150;
        a3 = a2;  // a3 ahora apunta al mismo objeto que a2
        
        if (a1 == a2) {  // false - objetos diferentes
            System.out.println(" UNO");
        }
        if (a1 == a3) {  // false - objetos diferentes
            System.out.println(" DOS");
        }
        if (a2 == a3) {  // true - misma referencia
            System.out.println(" TRES");  // Se imprime esto
        }
        
        // Para comparar valores, usar equals() (después de implementarlo)
        // if (a1.valor == a2.valor) { ... }
    }
}
