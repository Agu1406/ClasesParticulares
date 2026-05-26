package madrid.iescanaveral.ejercicios.convocatoria2022.resueltos;

/**
 * Ejercicio 1: ¿Qué se imprime cuando se compila y ejecuta el siguiente programa? - RESUELTO
 * 
 * RESPUESTA: El programa no se compila porque i no está inicializado.
 * En Java, las variables locales deben ser inicializadas antes de usarse.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio1_DoWhileInicializacion_RESUELTO {
    public static void main(String[] args) {
        // ERROR: La variable i no está inicializada
        // int i;
        // do {
        //     i++;  // Error de compilación: variable i might not have been initialized
        // } while (i < 0);
        // System.out.println(i);
        
        // SOLUCIÓN CORRECTA: Inicializar la variable antes de usarla
        int i = 0;
        do {
            i++;
        } while (i < 0);
        System.out.println(i); // Imprime 1
    }
}
