package ev3.ut9.pf.u01lambda.ejercicios.resueltos;



/**
 * Ejercicio 3 (Lambda y SAM): Runnable con lambda - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Mostrar sintaxis lambda aplicada a Runnable y ciclo de vida basico de un Thread.
 * 
 * Que hace este codigo resuelto:
 * Define un hilo con lambda que imprime un mensaje, lo arranca, espera con join dentro de try/catch y restaura el flag de interrupcion si ocurre error.
 * 
 * Conceptos que demuestra:
 *   - SAM Runnable: run() sin argumentos.
 *   - Thread + lambda en lugar de clase anonima verbosa.
 *   - join para sincronizar hilo principal con secundario.
 * 
 * Salida al ejecutar main:
 * Hola desde lambda
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio3_RunnableLambda_RESUELTO {
    public static void main(String[] args) {
        // Thread recibe Runnable lambda: tarea sin parametros que se ejecuta en hilo nuevo.
        Thread hilo = new Thread(() -> System.out.println("Hola desde lambda"));
        // start() lanza el hilo; el metodo run (lambda) se ejecuta en paralelo al main.
        hilo.start();
        // join puede lanzar InterruptedException; try/catch evita que el main termine sin esperar.
        try {
            // join bloquea el hilo principal hasta que la lambda del hilo secundario acaba.
            hilo.join();
        // Si otro hilo interrumpe join, capturamos la excepcion en lugar de ignorarla.
        } catch (InterruptedException e) {
            // interrupt() deja constancia de la interrupcion para quien consulte el hilo.
            Thread.currentThread().interrupt();
        // Cierre del bloque try/catch que envuelve la espera al hilo secundario.
        }
    }
}
