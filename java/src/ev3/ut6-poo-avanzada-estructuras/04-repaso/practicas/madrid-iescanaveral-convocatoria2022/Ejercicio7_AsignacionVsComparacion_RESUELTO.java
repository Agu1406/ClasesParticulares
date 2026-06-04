package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 7: ?Cual es la salida del siguiente codigo? - RESUELTO
 * 
 * RESPUESTA: El programa no compila
 * 
 * Explicacion:
 * - En la linea "if (i = 2)" se esta usando el operador de asignacion (=) en lugar de comparacion (==)
 * - En Java, no se puede usar una asignacion como condicion en un if (a menos que sea boolean)
 * - El compilador detecta este error y no permite compilar el codigo
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_AsignacionVsComparacion_RESUELTO {
    static boolean check;
    
    public static void main(String[] args) {
        int i;
        if (check == true) {
            i = 1;
        } else {
            i = 2;  // check es false por defecto, asi que i = 2
        }
        
        // ERROR: if (i = 2) no compila
        // CORRECCION: usar == para comparar
        if (i == 2) {
            i = i + 2;  // i = 2 + 2 = 4
        } else {
            i = i + 4;
        }
        System.out.println(i);  // Si se corrige, imprime 4
    }
}
