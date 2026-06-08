package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 12: ?Cual es la salida del siguiente programa? - RESUELTO
 * 
 * RESPUESTA: 4 4 8 6
 * 
 * Explicacion:
 * - i = j = 3: ambas variables valen 3
 * - ++i: pre-incremento, primero incrementa i a 4, luego usa el valor 4
 *   n = 2 * 4 = 8, e i ahora vale 4
 * - j++: post-incremento, primero usa el valor actual de j (3), luego incrementa j a 4
 *   m = 2 * 3 = 6, y j ahora vale 4
 * - Salida: "4 4 8 6"
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio12_OperadoresIncremento_RESUELTO {
    public static void main(String[] args) {
        int i, j;
        i = j = 3;  // i = 3, j = 3
        
        // Pre-incremento: primero incrementa, luego usa
        int n = 2 * ++i;  // i se incrementa a 4, luego n = 2 * 4 = 8
        
        // Post-incremento: primero usa, luego incrementa
        int m = 2 * j++;  // m = 2 * 3 = 6, luego j se incrementa a 4
        
        System.out.println(i + " " + j + " " + n + " " + m);  // Imprime: 4 4 8 6
    }
}
