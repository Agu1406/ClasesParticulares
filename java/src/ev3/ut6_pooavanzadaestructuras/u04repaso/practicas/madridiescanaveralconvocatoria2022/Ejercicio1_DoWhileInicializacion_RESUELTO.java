package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 1: ?Que se imprime cuando se compila y ejecuta el siguiente programa? - RESUELTO
 * 
 * RESPUESTA: El programa no se compila porque i no esta inicializado.
 * En Java, las variables locales deben ser inicializadas antes de usarse.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_DoWhileInicializacion_RESUELTO {
    public static void main(String[] args) {
        // ERROR: La variable i no esta inicializada
        // int i;
        // do {
        //     i++;  // Error de compilacion: variable i might not have been initialized
        // } while (i < 0);
        // System.out.println(i);
        
        // SOLUCION CORRECTA: Inicializar la variable antes de usarla
        int i = 0;
        do {
            i++;
        } while (i < 0);
        System.out.println(i); // Imprime 1
    }
}
