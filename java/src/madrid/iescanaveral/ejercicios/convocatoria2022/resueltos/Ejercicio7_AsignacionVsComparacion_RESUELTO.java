package madrid.iescanaveral.ejercicios.resueltos;

/**
 * Ejercicio 7: ¿Cuál es la salida del siguiente código? - RESUELTO
 * 
 * RESPUESTA: El programa no compila
 * 
 * Explicación:
 * - En la línea "if (i = 2)" se está usando el operador de asignación (=) en lugar de comparación (==)
 * - En Java, no se puede usar una asignación como condición en un if (a menos que sea boolean)
 * - El compilador detecta este error y no permite compilar el código
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio7_AsignacionVsComparacion_RESUELTO {
    static boolean check;
    
    public static void main(String[] args) {
        int i;
        if (check == true) {
            i = 1;
        } else {
            i = 2;  // check es false por defecto, así que i = 2
        }
        
        // ERROR: if (i = 2) no compila
        // CORRECCIÓN: usar == para comparar
        if (i == 2) {
            i = i + 2;  // i = 2 + 2 = 4
        } else {
            i = i + 4;
        }
        System.out.println(i);  // Si se corrige, imprime 4
    }
}
