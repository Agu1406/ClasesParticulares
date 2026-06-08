package ev3.ut6_pooavanzadaestructuras.u03concurrenciamultihilo.ejercicios.pendientes;

/**
 * Ejercicio: contador compartido con dos hilos (sin resolver).
 */
public class Ejercicio1_ContadorHilos_SIN_RESOLVER {

    private static int contador = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable tarea = () -> {
            // TODO: incrementar contador 1000 veces de forma segura.
        };

        Thread h1 = new Thread(tarea);
        Thread h2 = new Thread(tarea);
        h1.start();
        h2.start();
        h1.join();
        h2.join();

        System.out.println("Contador final: " + contador);
    }
}
