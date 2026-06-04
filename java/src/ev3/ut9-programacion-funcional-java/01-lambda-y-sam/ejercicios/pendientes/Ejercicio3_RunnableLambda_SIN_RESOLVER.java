package ev3.ut9.pf.lambda.pendientes;



/**
 * Ejercicio 3 (Lambda y SAM): Runnable con lambda en un hilo.
 * 
 * Proposito:
 * Introducir interfaces funcionales SAM distintas de Comparator: Runnable ejecuta codigo sin parametros ni valor de retorno, util para concurrencia basica.
 * 
 * Objetivos de aprendizaje:
 *   - Instanciar Thread con un Runnable lambda.
 *   - Llamar start para arrancar el hilo y join para esperar su finalizacion.
 *   - Gestionar InterruptedException de forma minima.
 * 
 * Tu tarea:
 * Crea un Thread cuya tarea (Runnable lambda) imprima "Hola desde lambda". Arranca el hilo, espera con join e imprime el mensaje desde el hilo secundario.
 * 
 * Salida esperada al ejecutar main:
 * Hola desde lambda
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_RunnableLambda_SIN_RESOLVER {
    public static void main(String[] args) {
        // TODO: crear Thread con Runnable lambda que imprima "Hola desde lambda"
        // TODO: start y join para esperar fin del hilo
    }
}
