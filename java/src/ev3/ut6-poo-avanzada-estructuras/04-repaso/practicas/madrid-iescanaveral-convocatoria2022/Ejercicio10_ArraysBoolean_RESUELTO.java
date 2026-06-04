package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 10: Dado el siguiente fragmento de codigo, indica cual es correcta - RESUELTO
 * 
 * RESPUESTA: foo tiene el valor false
 * 
 * Explicacion:
 * - En Java, los arrays de tipos primitivos se inicializan con valores por defecto
 * - Para boolean, el valor por defecto es false
 * - test[0], test[1], test[2] todos tienen valor false
 * - test[index] donde index=1, accede a test[1] que tiene valor false
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_ArraysBoolean_RESUELTO {
    public static void main(String[] args) {
        int index = 1;
        boolean[] test = new boolean[3];  // Array inicializado con false en todas las posiciones
        boolean foo = test[index];  // test[1] = false
        
        System.out.println("foo tiene el valor: " + foo);  // Imprime: false
        
        // Valores por defecto en Java:
        // boolean: false
        // int, byte, short, long: 0
        // float, double: 0.0
        // char: '\u0000'
        // Object: null
    }
}
